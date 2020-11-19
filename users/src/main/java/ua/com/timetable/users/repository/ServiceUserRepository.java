package ua.com.timetable.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.com.creator.entitycreator.domain.CalendarUser;
import ua.com.creator.entitycreator.domain.ServiceUser;



@Repository
public interface ServiceUserRepository extends JpaRepository<ServiceUser, Long>{
	
	@Query(value = "UPDATE SET calendar_user_id = ?1 WHERE id = ?2", nativeQuery = true)
	void setCalendarUserById(Long calendarUserId, Long serviceUserId);
	
	
	Optional<ServiceUser> findById(Long id);
	
	Optional<ServiceUser> findByCalendarUser(CalendarUser calendarUser);
	
	Optional<ServiceUser> findByCalendarUserName(String name);
	
	
}
