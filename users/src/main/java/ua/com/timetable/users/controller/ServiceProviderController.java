package ua.com.timetable.users.controller;


import org.bouncycastle.util.test.TestRandomEntropySourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import ua.com.timetable.users.properties.TestProperties;
import ua.com.timetable.users.service.TestService;

@RestController
@RequestMapping("/service_provider")
public class ServiceProviderController {
	
	
	private RestTemplate restTemplate;
	
	private DiscoveryClient discoveryClient;
	
	private TestService testService;
	
	private TestProperties testProperties;
	
	private Environment environment;
	
	
	@Autowired
	public ServiceProviderController(RestTemplate restTemplate, DiscoveryClient discoveryClient, TestService testService, TestProperties testProperties,
			Environment environment) {
		super();
		this.restTemplate = restTemplate;
		this.discoveryClient = discoveryClient;
		this.testService = testService;
		this.testProperties = testProperties;
		this.environment = environment;
	}


	@GetMapping
	public ResponseEntity<String> getTest() {
        return new ResponseEntity<>("Test successful", HttpStatus.OK);
    }
	
	
	
	
	@GetMapping("/test1")
	@HystrixCommand(fallbackMethod = "getFallbackUserRestTemplate"
	,
	commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errrorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
	}
)
	public String userRestTemplate() {
		String result = restTemplate.getForObject("http://appointments/appointment", String.class);
		
		return result;
	}
	
	public String getFallbackUserRestTemplate() {
		
		return new String("Hardocoded fallback resposne goes here");
	}
	
	@GetMapping("/test2")
	public String userRestTemplateWithTwoCalls() {
		String result = testService.getTestAppointments();
		
		String result2 = testService.getTestSearchengine();
		
		return result + ". and " + result2 + " and " + testProperties.getHolt();
	}
	
	@GetMapping("/test3")
	public String testEnviromentObject() {
		
		
//		return environment.getProperty(key);
		return null;
	}

}
