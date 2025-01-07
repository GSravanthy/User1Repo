package com.project.main.model;

import com.project.main.Validator.UniqueEmailValidator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

	private Integer id;

	@NotBlank(message = "Name should not blank")
	private String name;

	private Integer vaccinatedServiceId;

	@Email
	@NotBlank(message = "Email should not blank")
	@UniqueEmailValidator(message = "Email should be unique")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getVaccinatedServiceId() {
		return vaccinatedServiceId;
	}

	public void setVaccinatedServiceId(Integer vaccinatedServiceId) {
		this.vaccinatedServiceId = vaccinatedServiceId;
	}

}
