package ua.com.creator.entitycreator.domain.enums;

public enum AppointmentStatus {
	
	
	BOOKED("booked"),
	
	CONFIRMED("confirmed"),
	
	DENIED("denied"),
	
	DELETED("deleted");
	
	private String displayedname;

	private AppointmentStatus(String displayedname) {
		this.displayedname = displayedname;
	}

	public String getDisplayedname() {
		return displayedname;
	}

}
