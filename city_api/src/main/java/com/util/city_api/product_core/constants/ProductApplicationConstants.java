package com.util.city_api.product_core.constants;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class ProductApplicationConstants {

	   public static final Integer ACCESS_TOKEN_EXPERIMENT_TIME = 30 * 60 * 1000;

	   public static final String TOKEN_ISSUER = "city_api";

	   public static final String AUTH_HEADER = "Authorization";

	   public static final String TOKEN_START_WITH ="Bearer ";

	   public static final String MAIL_SEND_LINK = "";

	   public static final SecretKey TOKEN_ALGORITHM_KEY =Keys.secretKeyFor(SignatureAlgorithm.HS256);

	   public static Long REFRESH_TOKEN_EXPERIMENT_TIME = 3 * 86400000l; // DAY

	   public static Long CONFIRMATION_TOKEN_EXPERIMENT_TIME = 15l; // MINUTE
}
