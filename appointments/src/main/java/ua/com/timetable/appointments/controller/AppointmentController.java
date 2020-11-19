package ua.com.timetable.appointments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping
	public String getTest(){
		return new String("Test APPOINTMENT successful");
		
	}
	
	
	@GetMapping("/test1")
	public String getTestString(){
		return restTemplate.getForObject("http://SEARCHENGINE/address/string", String.class);
		//localhost:8084
		//return restTemplate.getForObject("http://localhost:8084/address/string", String.class);
	}

}
