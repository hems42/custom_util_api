package com.util.city_api.baseMockModel;

import java.time.LocalDateTime;

public class BaseUtilityModel {

	 public LocalDateTime getTime() {
			return LocalDateTime.of(2013, 11, 30, 22, 32, 34, 0);
	 }

	 
	 
	 // constructor
	 private static BaseUtilityModel _baseUtilityModel;
	 
	 private BaseUtilityModel() {}
	 
	 public static BaseUtilityModel getInstance() {
		 
		 if(_baseUtilityModel==null)
		 {
			 _baseUtilityModel = new BaseUtilityModel();
		 }
		 
		 return _baseUtilityModel;
	 }	
}
