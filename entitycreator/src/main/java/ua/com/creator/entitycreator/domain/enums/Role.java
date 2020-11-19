package ua.com.creator.entitycreator.domain.enums;

public enum Role {
	
	ROLE_SERVICE_USER("service user"),

	ROLE_SERVICE_PROVIDER("Provider"),
	
	ROLE_ADMIN("Admin");
	
	private String displayedname;
	
	Role(String displayedname) {
        this.displayedname = displayedname;
    }

    public String getDisplayedname() {
        return displayedname;
    }

}
