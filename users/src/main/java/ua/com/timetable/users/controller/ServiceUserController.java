package ua.com.timetable.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.creator.entitycreator.dto.IdDto;
import ua.com.creator.entitycreator.dto.ServiceUserCreationDto;
import ua.com.creator.entitycreator.dto.ServiceUserResponseDto;
import ua.com.creator.entitycreator.dto.UsernameDto;
import ua.com.timetable.users.service.ServiceUserService;

@RestController
@RequestMapping("/service_user")
public class ServiceUserController {
	
	
	private ServiceUserService serviceUserService;
	
	
	@Autowired	
	public ServiceUserController(ServiceUserService serviceUserService) {
		super();
		this.serviceUserService = serviceUserService;
	}



	@PostMapping("/create/{id}")
	public ServiceUserResponseDto createServiceUser(@PathVariable Long id, @RequestBody ServiceUserCreationDto serviceUserCreationDto) {
		
		ServiceUserResponseDto response = serviceUserService.createServiceUser(id, serviceUserCreationDto);
		return response;
	}
	
	@GetMapping
	public ResponseEntity<String> getTest(){
		return new ResponseEntity<>("Test USER successful", HttpStatus.OK);
	}
	
	@PostMapping("/get_id_by_name")
	public IdDto getUserServiceIdByCalnderUsername(@RequestBody UsernameDto dto){
		System.err.println(dto.getName());
		
		return serviceUserService.getIdByCalendarUserName(dto.getName());

	}
	
	

}
