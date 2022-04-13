package com.util.city_api.product_core.dtoConvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseMockEntity_DtoAndEntity_DtoModel;
import com.util.city_api.entity.log.LogUser;
import com.util.city_api.product_core.dto.logDto.LogUserDto;

public class LogUserDtoConvertorTest extends BaseMockEntity_DtoAndEntity_DtoModel{

	private LogUserDtoConvertor logUserDtoConvertor;
	private LogUser logUser;
	private LogUserDto logUserDto;
	
	@BeforeEach
	void setup()
	{
		this.logUserDtoConvertor = new LogUserDtoConvertor();
		logUser = super.getLogUser();
		logUserDto = super.getLogUserDto();
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
