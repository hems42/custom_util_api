package com.util.city_api.baseMockModel;

public class BaseTestWorkBench {

	private BaseMockDaoAndDaoModel baseMockDaoAndDaoModel = BaseMockDaoAndDaoModel.getInstance();
	
	private BaseMockDtoConvertorAndDtoConvertorModel baseMockDtoConvertorAndDtoConvertorModel = BaseMockDtoConvertorAndDtoConvertorModel.getInstance();
	
	private BaseMockEntity_DtoAndEntity_DtoModel baseMockEntity_DtoAndEntity_DtoModel = BaseMockEntity_DtoAndEntity_DtoModel.getInstance();
	
	private BaseMockRequest_ResponseAndRequest_ResponseModel baseMockRequest_ResponseAndRequest_ResponseModel = BaseMockRequest_ResponseAndRequest_ResponseModel.getInstance();
	
	private BaseMockServiceAndServiceModel baseMockServiceAndServiceModel = BaseMockServiceAndServiceModel.getInstance();
	
	private BaseUtilityModel baseUtilityModel = BaseUtilityModel.getInstance();
	
	//------------------------------------------------------------------------------

	public BaseMockDaoAndDaoModel getDaoModels() {
		return baseMockDaoAndDaoModel;
	}
	
	public BaseMockDtoConvertorAndDtoConvertorModel getDtoConvertorModels() {
		return baseMockDtoConvertorAndDtoConvertorModel;
	}
	
	public BaseMockEntity_DtoAndEntity_DtoModel getEntityDtoModels() {
		return baseMockEntity_DtoAndEntity_DtoModel;
	}
	
	public BaseMockRequest_ResponseAndRequest_ResponseModel getRequestRensponseModels() {
		return baseMockRequest_ResponseAndRequest_ResponseModel;
	}

	public BaseMockServiceAndServiceModel getServiceModels() {
		return baseMockServiceAndServiceModel;
	}
	
	public BaseUtilityModel getUtilityModels() {
		return baseUtilityModel;
	}
}
