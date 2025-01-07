package com.project.main.Service;

import java.util.List;
import com.project.main.Entity.Citizen;
import com.project.main.model.LoginRequestDTO;

public interface MainService {

	public List<Citizen> findAllCitizens();
	public List<Citizen> getByVaccinatedServiceId(Integer id);
	public Citizen saveCitizen(LoginRequestDTO newcitizenDTO);
//	public Citizen saveCitizen(Citizen newcitizenDTO);
	public String deleteCitizenById(Integer id);
	public Citizen getByCitizenId(Integer id);
}
