package com.project.main.Security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Component
public class UserPrinciple implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String name;
	private Collection<? extends GrantedAuthority> authorities;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return name;
	}

	public UserPrinciple() {
		super();
	}

	public UserPrinciple(Long userId, String name, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.userId = userId;
		this.name = name;
		this.authorities = authorities;
	}

}
