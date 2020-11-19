package ua.com.creator.entitycreator.domain.enums;

public enum AppointmentType {
	
	CUSTOMER("customer"),
	
	TIME_OFF("time_off"),
	
	BUSY("busy");
	
	private String displayedname;

	private AppointmentType(String displayedname) {
		this.displayedname = displayedname;
	}

	public String getDisplayedname() {
		return displayedname;
	}

}
