package ua.com.timetable.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {
	
	
	
	private RestTemplate restTemplate;

	@Autowired
	public TestService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	
	@HystrixCommand(fallbackMethod = "getFallbackTestAppointments")
	public String getTestAppointments() {
		return restTemplate.getForObject("http://appointments/appointment", String.class);
	}
	
	public String getFallbackTestAppointments() {
		return new String("I am a test fallback test appointment");
	}
	
	
	
	@HystrixCommand(fallbackMethod = "getFallbackTestSearchengine")
	public String getTestSearchengine() {
		return restTemplate.getForObject("http://searchengine/address/string", String.class);
	}
	
	public String getFallbackTestSearchengine() {
		return new String("I am a test fallback test searchengine");
	}
	

}
