package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.util.city_api.entity.primary.User;
import com.util.city_api.product_core.dto.primaryDto.UserDto;
import com.util.city_api.product_core.dtoConvertor.mockWorkbench.DtoConvertorTestWorkBench;

public class UserDtoConvertorTest extends DtoConvertorTestWorkBench{

	private UserDtoConvertor userDtoConvertor;
	
	@BeforeEach
	void setup()
	{
		this.userDtoConvertor = new UserDtoConvertor();
	}
	
    @Test
    void WhenUserConvertedToUserDtoThenReturnUserDtoThatAllParametersMustBeSameWithUserParamaters() {
    	
    	UserDto userDtoResult = userDtoConvertor.convert(user); 
    	
    	assertEquals(userDtoResult.getUserId(), user.getUserId());
    	assertEquals(userDtoResult.getUserName(),user.getUserName());
    	assertEquals(userDtoResult.getEMail(), user.getEMail());
    	assertEquals(userDtoResult.getPassword(), user.getPassword());
    	assertEquals(userDtoResult.getIsActive(), user.getIsActive());
    	assertEquals(userDtoResult.getIsBlocked(), user.getIsBlocked());
    	assertEquals(userDtoResult.getIsRegistered(), user.getIsRegistered());
    	assertEquals(userDtoResult.getRoles(), user.getRoles());
    	assertEquals(userDtoResult.getCreatedDate(), user.getCreatedDate());
    	assertEquals(userDtoResult.getUpdatedDate(), user.getUpdatedDate());   	       
    }
    
    @Test
    void WhenUserDtoConvertedToUserThenReturnUserThatAllParametersMustBeSameWithUserDtoParamaters() {
    	
    	User userResult = userDtoConvertor.convert(userDto);
    	
    	assertEquals(userResult.getUserId(), userDto.getUserId());
    	assertEquals(userResult.getUserName(),userDto.getUserName());
    	assertEquals(userResult.getEMail(), userDto.getEMail());
    	assertEquals(userResult.getPassword(), userDto.getPassword());
    	assertEquals(userResult.getIsActive(), userDto.getIsActive());
    	assertEquals(userResult.getIsBlocked(), userDto.getIsBlocked());
    	assertEquals(userResult.getIsRegistered(), userDto.getIsRegistered());
    	assertEquals(userResult.getRoles(), userDto.getRoles());
    	assertEquals(userResult.getCreatedDate(), userDto.getCreatedDate());
    	assertEquals(userResult.getUpdatedDate(), userDto.getUpdatedDate()); 
    }
}
