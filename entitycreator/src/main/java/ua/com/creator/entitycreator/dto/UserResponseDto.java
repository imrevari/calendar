package ua.com.creator.entitycreator.dto;

import ua.com.creator.entitycreator.domain.CalendarUser;

public class UserResponseDto {
	
	private Long id;

	private String name;
	
	private String role;
	
	

	public UserResponseDto() {
		super();
	}
	
	



	public UserResponseDto(CalendarUser calendarUser) {
		super();
		this.id = calendarUser.getId();
		this.name = calendarUser.getName();
		this.role = calendarUser.getRole().getDisplayedname();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

}
