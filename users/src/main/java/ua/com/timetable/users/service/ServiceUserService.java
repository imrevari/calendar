package ua.com.timetable.users.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.creator.entitycreator.domain.CalendarUser;
import ua.com.creator.entitycreator.domain.ServiceUser;
import ua.com.creator.entitycreator.dto.IdDto;
import ua.com.creator.entitycreator.dto.ServiceUserCreationDto;
import ua.com.creator.entitycreator.dto.ServiceUserResponseDto;
import ua.com.timetable.users.repository.ServiceUserRepository;

@Service
@Transactional
public class ServiceUserService {
	
	
	private ServiceUserRepository serviceUserRepository;

	@Autowired
	public ServiceUserService(ServiceUserRepository serviceUserRepository) {
		super();
		this.serviceUserRepository = serviceUserRepository;
	}

	
	
	
	public ServiceUserResponseDto createServiceUser(Long id, ServiceUserCreationDto serviceUserCreationDto) {
		
		CalendarUser calendarUser = new CalendarUser();
		
		calendarUser.setId(id);
		
		ServiceUser toSave = new ServiceUser(serviceUserCreationDto);
		
		toSave.setCalendarUser(calendarUser);
		
		ServiceUser serviceUser = serviceUserRepository.save(toSave);
		
		return new ServiceUserResponseDto(serviceUser);
	}




	public IdDto getIdByCalendarUserName(String name) {
//		CalendarUser calendarUser = new CalendarUser();
//		
//		calendarUser.setName(name);
		IdDto toReturn;
		
		Optional<ServiceUser> response = serviceUserRepository.findByCalendarUserName(name);
		if (response.isPresent()) {
			toReturn = new IdDto(response.get().getId());
		}else{
			toReturn = null;
		}
		return toReturn; 
	}


	
	
	
	

}
