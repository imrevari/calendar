package ua.com.timetable.login.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ua.com.creator.entitycreator.domain.enums.Role;

@Service
public class JwtUtil {
	
	@Value("secret.key")
	private String SECRET_KEY;
	
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Role extractRole(String token){
		final Claims claims = extractAllClaims(token);
		return Role.valueOf(claims.get("role").toString());
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	//ez kell
	public String generateTokenWithNoId(UserDetails userDetails) {
		Set<String> roles = AuthorityUtils.authorityListToSet(userDetails.getAuthorities());
		Map<String, Object> claims = new HashMap<>();
		roles.forEach(role -> claims.put("role", role));

		return createToken(claims, userDetails.getUsername());
	}
	
	//ez kell
	public String generateTokenWithId(UserDetails userDetails, Long id) {
		Set<String> roles = AuthorityUtils.authorityListToSet(userDetails.getAuthorities());
		Map<String, Object> claims = new HashMap<>();
		roles.forEach(role -> claims.put("role", role));
		
		claims.put("id", id);
		return createToken(claims, userDetails.getUsername());
	}
	
	//ez biztos h kell
	private String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 240))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	


}
