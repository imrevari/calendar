package ua.com.timetable.login.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.com.creator.entitycreator.domain.CalendarUser;
import ua.com.timetable.login.repository.CalendarUserRepository;

@Service
public class JPAUserDetailsService implements UserDetailsService{
	
	
	private CalendarUserRepository calendarUserRepository;
	
	@Autowired
	public JPAUserDetailsService(CalendarUserRepository calendarUserRepository) {
		super();
		this.calendarUserRepository = calendarUserRepository;
	}




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<CalendarUser> calendarUser = calendarUserRepository.findByName(username);
		
		if (!calendarUser.isPresent()) {
            throw new UsernameNotFoundException("No user found with name: " + username);
        }
		
		CalendarUser myUser = calendarUser.get();
		
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(myUser.getRole().toString());
		
		UserDetails principal = User.withUsername(username).authorities(authorities).password(myUser.getPassword()).build();
		
		
		return principal;
	}

}
