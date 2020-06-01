package com.fideljose.eureka_discovery.security;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fideljose.eureka_discovery.dto.ClientDto;
import com.fideljose.eureka_discovery.dto.LoginUserDto;
import com.fideljose.eureka_discovery.service.IClientService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private IClientService iClientService;
	private Environment env;
	
	public AuthenticationFilter(IClientService iClientService, Environment env, AuthenticationManager authenticationManager) {
		this.iClientService = iClientService;
		this.env = env;
		super.setAuthenticationManager(authenticationManager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
			HttpServletResponse response) throws AuthenticationException {
		try {
		LoginUserDto creds = new ObjectMapper()
				.readValue(req.getInputStream(), LoginUserDto.class);
		
		return this.getAuthenticationManager()
		          .authenticate(
		        		  new UsernamePasswordAuthenticationToken(
		        				  creds.getEmail(),
		        				  creds.getPassword(),
		        				  new ArrayList<>()
		        				  )
		        		  );
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req,
											HttpServletResponse res,
											FilterChain chain,
											Authentication auth) throws IOException, ServletException {
		String userName = ((User) auth.getPrincipal()).getUsername();
		ClientDto clientDto = iClientService.getUserDetailsByEmail(userName);
		
		final Calendar calendar = Calendar.getInstance();
	    calendar.add(Calendar.MINUTE, Integer.parseInt(env.getProperty("token.expiration_time")));
		String token = Jwts.builder()
	            			.setSubject(clientDto.getId().toString())
	            			.setExpiration(calendar.getTime())
				            .signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret"))
				            .compact();
		
		res.addHeader("id", clientDto.getId().toString());
		res.addHeader("token", token);
	}
}
