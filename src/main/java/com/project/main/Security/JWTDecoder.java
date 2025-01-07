package com.project.main.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTDecoder {

	@Autowired
	private JWTProperties properties;
	
	public DecodedJWT decode(String token) {
		return JWT.require(Algorithm.HMAC256(properties.getSecretkey()))
				.build().verify(token);
	}
}
