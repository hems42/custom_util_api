package com.util.city_api.product_core.dtoConvertor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.util.city_api.baseMockModel.BaseEntityAndDtoTestModel;
import com.util.city_api.entity.log.LogUser;
import com.util.city_api.product_core.dto.logDto.LogUserDto;

public class LogUserDtoConvertorTest extends BaseEntityAndDtoTestModel{

	private LogUserDtoConvertor logUserDtoConvertor;
	private LogUser logUser;
	private LogUserDto logUserDto;
	
	@BeforeEach
	void setup()
	{
		this.logUserDtoConvertor = Mockito.mock(LogUserDtoConvertor.class);
		logUser = super.getLogUser();
		logUserDto = super.getLogUserDto();
	}
 
    @Test
	void WhenLogUserConvertedToLogUserDtoThenReturnLogUserDtoThatAllParametersMustBeSameWitLogUserParamaters() {}
	
	  @Test
    void WhenLogUserDtoConvertedToLogUserThenReturnLogUserThatAllParametersMustBeSameWithLogUserDtoParamaters() {}
	
}
