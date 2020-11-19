package ua.com.creator.entitycreator.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ua.com.creator.entitycreator.domain.enums.Status;
import ua.com.creator.entitycreator.domain.enums.TypeOfService;

@Entity
public class ServiceProvider {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	private CalendarUser calendarUser;
	
	private String fullName;
	
	private String telNumber;
	
	private String email;
	
	private Status status;
	
	private TypeOfService typeOfService;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "serviceProvider")
	private Address address;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "serviceProvider")
	private List<Appointment> appointments;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "serviceProvider")
	private List<Review> reviews;

	public ServiceProvider() {
		super();
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public TypeOfService getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(TypeOfService typeOfService) {
		this.typeOfService = typeOfService;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
