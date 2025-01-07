package com.project.main.Security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTServer {

	@Autowired
	private JWTProperties properties;
	
	public String issue(long usedId,String name,List<String> roles)
	{
		return JWT.create()
				.withSubject(String.valueOf(usedId))
				.withClaim("name", name)
				.withClaim("roles", roles)
//				.withExpiresAt(Date.from(Instant.now().plusSeconds(3600)))
				.withExpiresAt(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
				.sign(Algorithm.HMAC256(properties.getSecretkey()));
	}
}
