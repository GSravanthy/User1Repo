package com.project.main.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class UserPrincipleAuthenticationToken extends AbstractAuthenticationToken {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	@Autowired
	private UserPrinciple principle;

	public UserPrincipleAuthenticationToken(UserPrinciple userPrinciple) {
		super(userPrinciple.getAuthorities());
		this.principle = userPrinciple;
		setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPrinciple getPrincipal() {
		return principle;
	}

}
