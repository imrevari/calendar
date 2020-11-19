package ua.com.creator.entitycreator.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ua.com.creator.entitycreator.dto.ServiceUserCreationDto;

@Entity
public class ServiceUser {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	private CalendarUser calendarUser;
	
	private String fullName;
	
	private String telNumber;
	
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "serviceUser")
	private List<Appointment> appointments;

	public ServiceUser() {
		super();
	}
	
	

	public ServiceUser(ServiceUserCreationDto serviceUserCreationDto) {
		super();
		this.fullName = serviceUserCreationDto.getFullName();
		this.telNumber = serviceUserCreationDto.getTelNumber();
		this.email = serviceUserCreationDto.getEmail();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CalendarUser getCalendarUser() {
		return calendarUser;
	}

	public void setCalendarUser(CalendarUser calendarUser) {
		this.calendarUser = calendarUser;
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

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
	

}
