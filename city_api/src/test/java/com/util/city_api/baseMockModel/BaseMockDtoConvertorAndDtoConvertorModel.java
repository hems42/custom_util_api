package com.util.city_api.baseMockModel;

import org.mockito.Mockito;

import com.util.city_api.product_core.dtoConvertor.LogRoleDtoConvertor;
import com.util.city_api.product_core.dtoConvertor.LogUserDtoConvertor;
import com.util.city_api.product_core.dtoConvertor.RoleDtoConvertor;
import com.util.city_api.product_core.dtoConvertor.UserDtoConvertor;

public class BaseMockDtoConvertorAndDtoConvertorModel {

	// dto convertor
	public UserDtoConvertor getUserDtoConvertor() {
		return new UserDtoConvertor();
	}
	
	public UserDtoConvertor getMockUserDtoConvertor() {
		return Mockito.mock(UserDtoConvertor.class);
	}
	
	public LogUserDtoConvertor getLogUserDtoConvertor() {
		return new LogUserDtoConvertor();
	}
	
	public LogUserDtoConvertor getMockLogUserDtoConvertor() {
		return Mockito.mock(LogUserDtoConvertor.class);
	}
	
	public RoleDtoConvertor getRoleDtoConvertor() {
		return new RoleDtoConvertor();
	}
	
	public RoleDtoConvertor getMockRoleDtoConvertor() {
		return Mockito.mock(RoleDtoConvertor.class);
	}
	
	public LogRoleDtoConvertor getLogRoleDtoconvertor() {
		return new LogRoleDtoConvertor();
	}
	
	public LogRoleDtoConvertor getMockLogRoleDtoconvertor() {
		return Mockito.mock(LogRoleDtoConvertor.class);
	}
	
	
	
	
	// constructor
	private static BaseMockDtoConvertorAndDtoConvertorModel _baseMockDtoConvertorAndDtoConvertorModel;

	public BaseMockDtoConvertorAndDtoConvertorModel() {}

	public static BaseMockDtoConvertorAndDtoConvertorModel getInstance() {
		if(_baseMockDtoConvertorAndDtoConvertorModel==null)
		{
			_baseMockDtoConvertorAndDtoConvertorModel = new BaseMockDtoConvertorAndDtoConvertorModel();
		}
		
		return _baseMockDtoConvertorAndDtoConvertorModel;
	}

}
