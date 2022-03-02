package com.util.city_api.dtoConvertorTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseEntityAndDtoTestModel;
import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;

public class UserDtoConvertorTest extends BaseEntityAndDtoTestModel{

	private UserDtoConvertor userDtoConvertor;
	
	@BeforeEach
	void init()
	{
		System.out.println("önce çalışan");
		this.userDtoConvertor = Mockito.mock(UserDtoConvertor.class);
	}
	
    @Test
    void IfUserconvertedToUserDtoItMustBeSameAllParameter() {
    	
        
    }
    
    @Test
    void convert2() {
    	System.out.println("sonra 2çalışan");
        
    }
    
    
    @Test
    void convert3() {
    	System.out.println("sonra 3çalışan");
        
    }
    
    
    @Test
    void convert() {
    	System.out.println("sonra 4çalışan");
        
    }

}
