package com.util.city_api.core.constant;

public enum CoreEnumRoles {
	
	ADMIN(RoleUtils.roleTitle+"ADMIN","fully permission","0001"),
	SUPER_USER(RoleUtils.roleTitle+"SUPER_USER","has permission up user","0002"),
	USER(RoleUtils.roleTitle+"USER","has user permissions","0003");
	
    private String roleName;
    private String roleDescription;
    private String roleCode;

    CoreEnumRoles(String exceptionMessage, String exceptionCode, String roleDescription) {
        this.roleName = exceptionMessage;
        this.roleCode = exceptionCode;
        this.roleDescription = roleDescription;
    }


    public String getRoleName() {
        return roleName;
    }
    
    public String getRoleDescription() {
        return roleDescription;
    }

    public String getRoleCode() {
        return roleCode;
    }     
    
}

class RoleUtils { static String roleTitle = "ROLE_";}