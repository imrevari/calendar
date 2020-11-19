package ua.com.creator.entitycreator.domain.enums;

public enum Status {
	
	
	ACTIVE("active"),
	
	DELETED("deleted"),
	
	REGISTERED("registered"),
	
	SUSPENDED("suspended");
	
	private String displayedname;

	private Status(String displayedname) {
		this.displayedname = displayedname;
	}

	public String getDisplayedname() {
		return displayedname;
	}
	
	

}
