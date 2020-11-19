package ua.com.creator.entitycreator.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ua.com.creator.entitycreator.domain.enums.Role;


@Entity
public class CalendarUser {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique=true)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	@Column(columnDefinition = "TIMESTAMP", nullable = false)
	private LocalDateTime creationTime;
	
	private Role role;
	

	public CalendarUser() {
		super();
	}

	
	public CalendarUser(String name, String password, Role role) {
		super();
		this.name = name;
		this.password = password;
		this.creationTime = LocalDateTime.now();
		this.role = role;
	}
	

	public CalendarUser(String name, Role role) {
		super();
		this.name = name;
		this.creationTime = LocalDateTime.now();
		this.role = role;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	

}
