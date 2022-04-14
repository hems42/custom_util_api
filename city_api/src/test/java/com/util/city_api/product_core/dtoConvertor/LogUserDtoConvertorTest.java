package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.util.city_api.entity.log.LogUser;
import com.util.city_api.product_core.dto.logDto.LogUserDto;
import com.util.city_api.product_core.dtoConvertor.mockWorkbench.DtoConvertorTestWorkBench;

public class LogUserDtoConvertorTest extends DtoConvertorTestWorkBench{

	private LogUserDtoConvertor logUserDtoConvertor;
	
	@BeforeEach
	void setup()
	{
		this.logUserDtoConvertor = new LogUserDtoConvertor();

	}
 
    @Test
	void WhenLogUserConvertedToLogUserDtoThenReturnLogUserDtoThatAllParametersMustBeSameWitLogUserParamaters() {
    	
    	LogUserDto logUserDtoResult = logUserDtoConvertor.convert(logUser);
    	
    	assertEquals(logUserDtoResult.getLogUserId(), logUser.getLogUserId());
    	assertEquals(logUserDtoResult.getTransactionType(), logUser.getTransactionType());
    	assertEquals(logUserDtoResult.getUser(), logUser.getUser());
    	assertEquals(logUserDtoResult.getPerformingTransactionBy(), logUser.getPerformingTransactionBy());
    	assertEquals(logUserDtoResult.getCreatedDate(), logUser.getCreatedDate());
    }
	
	  @Test
    void WhenLogUserDtoConvertedToLogUserThenReturnLogUserThatAllParametersMustBeSameWithLogUserDtoParamaters() {
	    	
	      LogUser logUserResult = logUserDtoConvertor.convert(logUserDto);
	    	
	      assertEquals(logUserResult.getLogUserId(), logUserDto.getLogUserId());
	      assertEquals(logUserResult.getTransactionType(), logUserDto.getTransactionType());
	      assertEquals(logUserResult.getUser(), logUserDto.getUser());
	      assertEquals(logUserResult.getPerformingTransactionBy(), logUserDto.getPerformingTransactionBy());
	      assertEquals(logUserResult.getCreatedDate(), logUserDto.getCreatedDate());
	  }
	
}
