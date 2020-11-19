package ua.com.creator.entitycreator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String review;
	
	private Integer stars;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_provider_id", nullable = false)
	private ServiceProvider serviceProvider;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_user_id")
	private ServiceUser serviceUser;


	public Review() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public Integer getStars() {
		return stars;
	}


	public void setStars(Integer stars) {
		this.stars = stars;
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
	
	
	

}
