package com.ahmedeid.securityandjwt.demo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ahmedeid.securityandjwt.demo.services.UserService;

public class AuthFilter extends OncePerRequestFilter {

	@Value("${auth.header}")
	private String TOKEN_HEADER;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		 final String header = request.getHeader(TOKEN_HEADER);
		 final SecurityContext securityContext = SecurityContextHolder.getContext();

		 if(header != null && securityContext.getAuthentication() == null) {
			 String token = header.split("ahmbas ")[1];
			 String userName = tokenUtil.getUserNameFromToken(token);
			 if(userName != null) {
				 UserDetails userDetails = userService.loadUserByUsername(userName); 
				 if(tokenUtil.isTokenValid(token, userDetails)) {
					 UsernamePasswordAuthenticationToken authentication = 
							 new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					 authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					 SecurityContextHolder.getContext().setAuthentication(authentication);
				 }
			 }
		 }
		filterChain.doFilter(request, response);
	}
}
