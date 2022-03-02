package com.util.city_api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.util.city_api.dao.CityDao;
import com.util.city_api.entity.City;

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
	
	public static void main(String[] args) {
		SpringApplication.run(CityApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	//	dao.findAll().forEach(c -> System.out.println(c.toString()+" gelen şehir bilgisi"));
		
		// TODO Auto-generated method stub
	
		/*City city;
		for(int i=0;i<100;i++)
		{
			city = new City(null,"KONYA","42",LocalDateTime.now(), LocalDateTime.now());
			
			dao.save(city);
		}
		*/
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
