package com.project.main.Security;

import org.springframework.stereotype.Component;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtToUserPrincipleConverter {

	@Autowired
	private UserPrinciple principle;

	public UserPrinciple convet(DecodedJWT jwt) {
		principle.setUserId(Long.valueOf(jwt.getSubject()));
		principle.setName(jwt.getClaim("name").asString());
		principle.setAuthorities(extractAuthoritiesFromClaim(jwt));
		return principle;
	}

	private List<SimpleGrantedAuthority> extractAuthoritiesFromClaim(DecodedJWT jwt) {
		var claim = jwt.getClaim("roles");
		if (claim.isNull() || claim.isMissing())
			return List.of();
		return claim.asList(SimpleGrantedAuthority.class);
	}
}
