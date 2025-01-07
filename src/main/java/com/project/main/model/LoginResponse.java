package com.project.main.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
