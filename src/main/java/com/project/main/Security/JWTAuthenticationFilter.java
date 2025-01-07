package com.project.main.Security;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JWTDecoder jwtDecoder;
	@Autowired
	private JwtToUserPrincipleConverter jwtToUserPrincipleConverter;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		extractTokenFromRequest(request)
		.map(jwtDecoder::decode)
		.map(jwtToUserPrincipleConverter::convet)
		.map(UserPrincipleAuthenticationToken::new)
		.ifPresent(authentication -> SecurityContextHolder.getContext().setAuthentication(authentication));
		
		filterChain.doFilter(request, response);
	}

	private Optional<String> extractTokenFromRequest(HttpServletRequest request){
		Enumeration<String> tokens = request.getHeaderNames();
		String token = request.getHeader("Authorization");
		if(token != null && StringUtils.hasText(token) && token.startsWith("Bearer ")) {
			return Optional.of(token.substring(7));		//because of token start "Bearer "
		}
		return Optional.empty();
	}
}
