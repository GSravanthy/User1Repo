package com.project.main.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.main.Security.JWTServer;
import com.project.main.model.LoginRequestDTO;
import lombok.RequiredArgsConstructor;

@RestController
//@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	@Autowired
	private JWTServer jWTServer;
	
	@PostMapping("/auth/login")
	public ResponseEntity<String> getLoginResponse(@RequestBody @Validated LoginRequestDTO request) {
		String token = jWTServer.issue(1L, request.getName(), List.of("USER"));
//		LoginResponse accessToken = new LoginResponse();
//		accessToken.setAccessToken(token);
		return new ResponseEntity<>(token,HttpStatus.OK);
	}
}
