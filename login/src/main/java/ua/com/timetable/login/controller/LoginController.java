package ua.com.timetable.login.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ua.com.creator.entitycreator.domain.enums.Role;
import ua.com.creator.entitycreator.dto.IdDto;
import ua.com.creator.entitycreator.dto.UsernameDto;
import ua.com.timetable.login.dto.AuthenticationRequest;
import ua.com.timetable.login.dto.AuthenticationResponse;
import ua.com.timetable.login.security.JwtUtil;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	
	private AuthenticationManager authenticationManager;
	
	private UserDetailsService userDetailsService;
	
	private JwtUtil jwtUtil;
	
	private RestTemplate restTemplate;
	
	
	
	@Autowired
	public LoginController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService,
			JwtUtil jwtUtil, RestTemplate restTemplate) {
		super();
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.jwtUtil = jwtUtil;
		this.restTemplate = restTemplate;
	}	






	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> calendarUserLoginAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or passowrd", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = generateJwtWithId(userDetails);
		return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
	}
	
	
	
	public ResponseEntity<AuthenticationResponse> calendarUserLoginWithFacebook(){
		
		
		
		return null;
	}
	
	
	
	
	
	private Long getServiceUserIdByCalendarUserName(UserDetails userDetails) {
		
		String tempt_token = jwtUtil.generateTokenWithNoId(userDetails);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(tempt_token);
		HttpEntity<UsernameDto> entity = new HttpEntity<>(new UsernameDto(userDetails.getUsername()), headers);
		
		IdDto dto = restTemplate.postForObject("http://users/service_user/get_id_by_name", entity, IdDto.class);	
		return dto.getId();
	}
	
	
	private String generateJwtWithId(UserDetails userDetails) {
		Set<String> authorities = AuthorityUtils.authorityListToSet(userDetails.getAuthorities());	
		//if user is service_user
		if (!authorities.isEmpty() && Role.valueOf(authorities.iterator().next()) == Role.ROLE_SERVICE_USER){
			//get service_user id from other microservice
			Long serviceUserId = getServiceUserIdByCalendarUserName(userDetails);
			
			return jwtUtil.generateTokenWithId(userDetails, serviceUserId);
		}else {
			return jwtUtil.generateTokenWithId(userDetails, null);
		}
	}





	
	
	
	
	

}
