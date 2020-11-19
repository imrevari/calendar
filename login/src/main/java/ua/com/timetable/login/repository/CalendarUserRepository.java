package ua.com.timetable.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.com.creator.entitycreator.domain.CalendarUser;


@Repository
public interface CalendarUserRepository extends JpaRepository<CalendarUser, Long>{
	
	
	Optional<CalendarUser> findByName(String name);

}
