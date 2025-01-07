package com.project.main.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.main.Entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer>{

	public List<Citizen> findByVaccinatedServiceId(Integer vaccinatedServiceId);
	
	public List<Citizen> findByEmail(String email);
}
