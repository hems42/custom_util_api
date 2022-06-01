package com.util.city_api.product_core.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.util.city_api.product_core.constants.ProductApplicationConstants.ACCESS_TOKEN_EXPERIMENT_TIME;
import static com.util.city_api.product_core.constants.ProductApplicationConstants.TOKEN_ALGORITHM_KEY;

@Service
public class JwtUtil {

    // verilen token a ait kullanıcı adını döndürür.
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // verilen token a ait token bitiş süresini verir.
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaimsByToken(token);
        return claimsResolver.apply(claims);
    }

    
    // token ın geçerlilik süre doldu mu?
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // userDetails objesini alır. createToken metoduna gönderir.
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims)
                .setSubject(subject) // ilgili kullanıcı
                .setIssuedAt(new Date(System.currentTimeMillis())) // başlangıç
                // ı will add claim with roles...
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPERIMENT_TIME)) // bitiş
                .signWith(TOKEN_ALGORITHM_KEY) // kullanılan algoritma ve bu algoritma çalışırken kullanılacak hash key değeri
                .compact();
    }

    // token hala geçerli mi? kullanıcı adı doğru ise ve token ın geçerlilik süresi devam ediyorsa true döner.
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
    // util metods 
    
    private Claims getClaimsByToken(String token) {
    	return getJwtPaser().parseClaimsJwt(token).getBody();
    }
    
     private JwtParser getJwtPaser() {
    	return Jwts.parserBuilder().setSigningKey(TOKEN_ALGORITHM_KEY).build();
    }
}

