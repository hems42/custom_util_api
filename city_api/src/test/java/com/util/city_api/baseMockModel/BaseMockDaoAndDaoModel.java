package com.util.city_api.baseMockModel;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.util.city_api.dao.LogRoleDao;
import com.util.city_api.dao.LogUserDao;
import com.util.city_api.dao.RoleDao;
import com.util.city_api.dao.UserDao;

public class BaseMockDaoAndDaoModel {
	
	@Autowired
    private UserDao userDao;
    
	@Autowired
    private LogUserDao logUserDao;
	
	@Autowired
    private RoleDao roleDao;
    
	@Autowired
    private LogRoleDao logRoleDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public UserDao getMockUserDao() {
		return Mockito.mock(UserDao.class);
	}
	
	public LogUserDao getLogUserDao() {
		return logUserDao;
	}
	
	public LogUserDao getMockLogUserDao() {
		return Mockito.mock(LogUserDao.class);
	}
	
	public RoleDao getRoleDao() {
		return roleDao;
	}
	
	public RoleDao getMockRoleDao () {
		return Mockito.mock(RoleDao.class);
	}
	
	public LogRoleDao getLogRoleDao() {
		return logRoleDao;
	}
	
	public LogRoleDao getMockLogRoleDao () {
		return Mockito.mock(LogRoleDao.class);
	}
	
	
	
	// constructor
	private static BaseMockDaoAndDaoModel _baseMockDaoAndDaoModel;
	
	public BaseMockDaoAndDaoModel() {}
	
	public static BaseMockDaoAndDaoModel getInstance() {
		if(_baseMockDaoAndDaoModel==null)
		{
			_baseMockDaoAndDaoModel = new BaseMockDaoAndDaoModel();
		}
		return _baseMockDaoAndDaoModel;
	}
}
