package com.project.main.Entity;

import java.util.Date;

import org.springframework.dao.DataAccessException;

import com.project.main.Validator.UniqueEmailValidator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column
	private String name;
	@Column
	private int vaccinatedServiceId;
	@Column
	private String email;
	@Column
	private Date creationDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVaccinatedServiceId() {
		return vaccinatedServiceId;
	}
	public void setVaccinatedServiceId(int vaccinatedServiceId) {
		this.vaccinatedServiceId = vaccinatedServiceId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
