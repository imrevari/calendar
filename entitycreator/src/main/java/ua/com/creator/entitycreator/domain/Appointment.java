package ua.com.creator.entitycreator.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ua.com.creator.entitycreator.domain.enums.*;

@Entity
public class Appointment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TIMESTAMP", nullable = false)
	private LocalDateTime fromDate;
	
	@Column(columnDefinition = "TIMESTAMP", nullable = false)
	private LocalDateTime toDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_provider_id", nullable = false)
	private ServiceProvider serviceProvider;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_user_id")
	private ServiceUser serviceUser;
	
	
	private AppointmentStatus appointmentStatus;
	
	
	private AppointmentType appointmentType;
	
	
	private String comment;


	public Appointment() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getFromDate() {
		return fromDate;
	}


	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}


	public LocalDateTime getToDate() {
		return toDate;
	}


	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}


	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}


	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}


	public ServiceUser getServiceUser() {
		return serviceUser;
	}


	public void setServiceUser(ServiceUser serviceUser) {
		this.serviceUser = serviceUser;
	}


	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}


	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}


	public AppointmentType getAppointmentType() {
		return appointmentType;
	}


	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	

}
