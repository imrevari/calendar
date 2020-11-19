package ua.com.timetable.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard //only if you want a hystrix dashboard
@ComponentScan("ua.com.creator")
@ComponentScan("ua.com.timetable.users")
public class UsersApplication {
	
	//not preferred way to make set up timeout
	@LoadBalanced
	@Bean
	public RestTemplate getResrTemplate() {
//		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//		httpComponentsClientHttpRequestFactory.setConnectTimeout(3000); //3 seconds
//		return new RestTemplate(httpComponentsClientHttpRequestFactory);
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
