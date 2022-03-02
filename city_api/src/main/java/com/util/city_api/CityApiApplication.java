package com.util.city_api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.util.city_api.dao.CityDao;
import com.util.city_api.dao.TerritoryDao;
import com.util.city_api.entity.City;
import com.util.city_api.entity.Territory;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CityApiApplication implements CommandLineRunner{

	@Autowired
	CityDao dao;
	
	@Autowired
	TerritoryDao dao2;
	
	public static void main(String[] args) {
		SpringApplication.run(CityApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	//	dao.findAll().forEach(c -> System.out.println(c.toString()+" gelen şehir bilgisi"));
		
		// TODO Auto-generated method stub
	
	Territory territory =	dao2.save(new Territory(null,"İÇ ANADOLU", "MEMLEKET GÜZEL İNSANI YARAK", LocalDateTime.now(),LocalDateTime.now()));
		
		City city;
		for(int i=0;i<100;i++)
		{
			city = new City(null,territory,"KONYA"+i,"42"+i,"42000"+i,"332"+i,"konya güzel memleket yaşanabilir...",LocalDateTime.now(), LocalDateTime.now());
			
			dao.save(city);
		}
		
	}

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.util.city_api"))
                .paths(PathSelectors.any())
                .build();
    }
	
}
