package ua.com.creator.entitycreator.dto;

import ua.com.creator.entitycreator.domain.ServiceUser;

public class ServiceUserResponseDto {
	
	
	private Long id;
	
	private Long calendarUserId;
	
	private String calendarUserName;
	
	private String fullName;
	
	private String telNumber;
	
	private String email;

	
	public ServiceUserResponseDto() {
		super();
	}
	
	


	public ServiceUserResponseDto(ServiceUser serviceUser) {
		super();
		this.id = serviceUser.getId();
		this.calendarUserId = serviceUser.getCalendarUser().getId();
		this.calendarUserName = serviceUser.getCalendarUser().getName();
		this.fullName = serviceUser.getFullName();
		this.telNumber = serviceUser.getTelNumber();
		this.email = serviceUser.getEmail();
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCalendarUserId() {
		return calendarUserId;
	}


	public void setCalendarUserId(Long calendarUserId) {
		this.calendarUserId = calendarUserId;
	}


	public String getCalendarUserName() {
		return calendarUserName;
	}


	public void setCalendarUserName(String calendarUserName) {
		this.calendarUserName = calendarUserName;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getTelNumber() {
		return telNumber;
	}


	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
