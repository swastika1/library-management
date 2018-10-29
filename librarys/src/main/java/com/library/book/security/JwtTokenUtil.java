//package com.library.book.security;
//
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.function.Function;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import com.library.book.model.Login;
//import com.library.book.util.Constant;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts; 
//
//
//@SuppressWarnings("serial")
//@Component
//public class JwtTokenUtil implements Serializable {
//	
//	public String getUsernameFromToken(String token) {
//		return getClaimFromToken(token, Claims::getSubject);
//	}
//
//	public Date getExpirationDateFromToken(String token) {
//		return getClaimFromToken(token, Claims::getExpiration);
//	}
//
//	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//		final Claims claims = getAllClaimsFromToken(token);
//		return claimsResolver.apply(claims);
//	}
//
//	private Claims getAllClaimsFromToken(String token) {
//		return Jwts.parser().setSigningKey(Constant.SIGNING_KEY).parseClaimsJws(token).getBody();
//	}
//
//	private Boolean isTokenExpired(String token) {
//		final Date expiration = getExpirationDateFromToken(token);
//		return expiration.before(new Date());
//	}
//
//	public String generateToken(Login user) {
//		return doGenerateToken(user.getUserName());
//	}
//		
////	@Autowired
////	private CustomJwt custom;
//	
//	/*END*/
//	private String doGenerateToken(String username) {
//		
//		/*Custom JWT*/
//		
//		
//	/*	Login login=loginRepository.findByUsername(username);
//		User user = userRepository.findByIdAndStatusNot(login.getUser().getId(), Status.DELETED);
//		State state=stateRepository.findById(user.getState().getId());			
//		District district=districtRepository.findById(user.getDistrict().getId());
//		String localLevel=commonService.findLocalLevel(user);
//		*/
//		/*END*/
//		
//		Claims claims = Jwts.claims().setSubject(username);
//		claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority("ADMIN")));
//		
//		return Jwts.builder().setClaims(claims).setIssuer("http://softechFoundation.com")
//				.setId(login.getId().toString())
//				.claim("Locallevel", localLevel)
//				.claim("District", district.getDistrict())
//				.claim("state", state.getState())
//				.setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + Constant.ACCESS_TOKEN_VALIDITY_SECONDS * 100000))
//				.signWith(SignatureAlgorithm.HS256, Constant.SIGNING_KEY).compact();
//		
//	}
//
//	public Boolean validateToken(String token, UserDetails userDetails) {
//		final String username = getUsernameFromToken(token);
//		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//	}
//
//}
