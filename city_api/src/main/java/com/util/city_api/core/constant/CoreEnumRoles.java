package com.util.city_api.core.constant;

public enum CoreEnumRoles {
	
	ADMIN(RoleUtils.roleTitle+"ADMIN","0001"),
	SUPER_USER(RoleUtils.roleTitle+"SUPER_USER","0002"),
	USER(RoleUtils.roleTitle+"USER","0003");
	
    private String roleName;
    private String roleCode;

    CoreEnumRoles(String exceptionMessage, String exceptionCode) {
        this.roleName = exceptionMessage;
        this.roleCode = exceptionCode;
    }


    public String getRoleName() {
        return roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }
    
    
}

class RoleUtils { static String roleTitle = "ROLE_";}