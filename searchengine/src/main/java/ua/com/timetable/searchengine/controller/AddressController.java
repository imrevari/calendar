package ua.com.timetable.searchengine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {


	@GetMapping
	public ResponseEntity<String> getTest(){
		return new ResponseEntity<>("Test ADDRESS successful", HttpStatus.OK);
	}
	
	
	@GetMapping("/string")
	public String getTestString(){
		return new String("Test ADDRESS successful Pista Jancsi");
	}

}
