package com.project.main.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.main.Entity.Citizen;
import com.project.main.Exception.BusinessException;
import com.project.main.Exception.EmptyException;
import com.project.main.Mapper.CitizenPopulator;
import com.project.main.Repo.CitizenRepo;
import com.project.main.model.LoginRequestDTO;

@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	public CitizenRepo repo;
	
	public List<Citizen> findAllCitizens(){
		List<Citizen> citizens = repo.findAll();
		return citizens; 
	}
	
	public List<Citizen> getByVaccinatedServiceId(Integer id) {
		List<Citizen> citizens = null;
		try {
			citizens = repo.findByVaccinatedServiceId(id);
		} catch (NoSuchElementException e) {
//			throw new BusinessException("1005", "Mentioned ID not Existed");
		}
		if (citizens.isEmpty()) {
			throw new EmptyException("1006", "global EmptyException called");
		}
		return citizens;
	}
	
	public Citizen saveCitizen(LoginRequestDTO newcitizenDTO) {
//		public Citizen saveCitizen(LoginRequestDTO newcitizenDTO) {
		if (newcitizenDTO.getName().isEmpty() || newcitizenDTO.getName().length() == 0) {
			throw new BusinessException("1001", "Name is empty, Please provide valid one");
		}
		try {
			Citizen newcitizen = CitizenPopulator.INSTANCE.populateCitizen(newcitizenDTO);
			newcitizen.setCreationDate(new Date());
			Citizen citizen = repo.save(newcitizen);
			return citizen;
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1002", "Name is null here"+ e.getMessage());
		}
	}
	
	public String deleteCitizenById(Integer id){
		repo.deleteById(id);
		return "Deleted successfully";
	}

	@Override
	public Citizen getByCitizenId(Integer id) {
		Citizen citizen = repo.findById(id).get();
		return citizen;
	}
}
