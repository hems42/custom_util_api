package com.util.city_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @GetMapping("/dene")
    public ResponseEntity<?> signup() {

   
    	return ResponseEntity.ok("anan anan ...");
    }
	
}
