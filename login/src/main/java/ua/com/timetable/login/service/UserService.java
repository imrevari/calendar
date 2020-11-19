package ua.com.timetable.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.creator.entitycreator.domain.CalendarUser;
import ua.com.creator.entitycreator.domain.enums.Role;
import ua.com.creator.entitycreator.dto.ServiceUserCreationDto;
import ua.com.creator.entitycreator.dto.UserResponseDto;
import ua.com.timetable.login.repository.CalendarUserRepository;

@Service
@Transactional
public class UserService {

	
	private CalendarUserRepository calendarUserRepository;
	
	
	@Autowired
	public UserService(CalendarUserRepository calendarUserRepository) {
		super();
		this.calendarUserRepository = calendarUserRepository;
	}





	public UserResponseDto createCalendarUser(ServiceUserCreationDto serviceUserCreationDto, Role roleServiceUser) {
		
		CalendarUser calendarUser = new CalendarUser(serviceUserCreationDto.getName(), roleServiceUser);

//		calendarUser.setPassword(serviceUserCreationDto.getPassword().concat(calendarUser.getCreationTime().toString()));
		calendarUser.setPassword(serviceUserCreationDto.getPassword());

		return new UserResponseDto(calendarUserRepository.save(calendarUser));
	}

}
