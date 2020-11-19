package ua.com.creator.entitycreator.domain.enums;

public enum TypeOfService {
	
	BARBER("barber", ""),
	
	HAIRDRESSES("hairdreser", ""),
	
	MANICURE("manicure", ""),
	
	DOCTOR("pedicure", ""),
	
	DANTIST("dantist", ""),
	
	ETC("etc", "");
	
	
	
	private String displayedname;
	
	private String url;

	private TypeOfService(String displayedname, String url) {
		this.displayedname = displayedname;
		this.url = url;
	}

	public String getDisplayedname() {
		return displayedname;
	}

	public String getUrl() {
		return url;
	}


}
