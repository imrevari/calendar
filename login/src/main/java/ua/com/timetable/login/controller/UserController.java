package ua.com.timetable.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ua.com.creator.entitycreator.domain.enums.Role;
import ua.com.creator.entitycreator.dto.ServiceUserCreationDto;
import ua.com.creator.entitycreator.dto.ServiceUserResponseDto;
import ua.com.creator.entitycreator.dto.UserResponseDto;
import ua.com.timetable.login.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	private UserService userService;
	
	private RestTemplate restTemplate;
	
	
	@Autowired
	public UserController(UserService userService, RestTemplate restTemplate) {
		super();
		this.userService = userService;
		this.restTemplate = restTemplate;
	}



	@GetMapping
	public ResponseEntity<String> getTest(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) authentication.getPrincipal();
		return new ResponseEntity<>("Test USER successful " + user.getUsername() + " and " + user.getAuthorities().toString() + 
				" and pass:" + user.getPassword(), HttpStatus.OK);
	}
	

	@PostMapping("/create_servuser")
	public ResponseEntity<ServiceUserResponseDto> createNewServiceUser(@RequestBody ServiceUserCreationDto serviceUserCreationDto){

		//create user in service
		UserResponseDto userResponseDto = userService.createCalendarUser(serviceUserCreationDto, Role.ROLE_SERVICE_USER);

		//pass over to other microservice to create ServiceUser
		ServiceUserResponseDto serviceUserResponseDto = 
				restTemplate.postForObject("http://users/service_user/create/" + userResponseDto.getId(), serviceUserCreationDto, ServiceUserResponseDto.class);
		serviceUserResponseDto.setCalendarUserName(userResponseDto.getName());
		
		return new ResponseEntity<>(serviceUserResponseDto, HttpStatus.OK);
	}
	
	

}
