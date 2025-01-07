package com.project.main.Controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.main.Entity.Citizen;
import com.project.main.Exception.BusinessException;
import com.project.main.Exception.ControllerException;
import com.project.main.Repo.CitizenRepo;
import com.project.main.Service.MainService;
import com.project.main.model.LoginRequestDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/citizen")
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	public CitizenRepo repo;
	@Autowired
	public MainService service;
	
	@RequestMapping("/register")
	public String test(){
		return "WELCOME";
	}
	
	@RequestMapping("/admin")
	public ResponseEntity<String> getAdmin(){
		logger.info("Info log of Main controller getAdmin() called..");
		return new ResponseEntity<>("Hello Admin",HttpStatus.OK);
	}
	
	@RequestMapping("/user")
	public ResponseEntity<String> getUser(){
		logger.trace("trace log of Main controller getUser() called..");
		logger.info("Info log of Main controller getUser() called..");
		return new ResponseEntity<>("Hello User",HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Citizen>> getAllCitizens(){
		logger.info("Info log of Main controller getAllCitizens() called..");
		List<Citizen> citizens = service.findAllCitizens();
		return new ResponseEntity<>(citizens,HttpStatus.OK); 
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<?> addCitizen(@RequestBody @Valid LoginRequestDTO newcitizen){
//	public ResponseEntity<?> addCitizen(@RequestBody Citizen newcitizen){
		logger.info("Info log of Main controller addCitizen() called..");
		try {
		Citizen citizen = service.saveCitizen(newcitizen);
		return new ResponseEntity<Citizen>(citizen,HttpStatus.CREATED);
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorName());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce = new ControllerException("1004","Error occured in Controller layer while calling citizen saving");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> getByVaccinatedServiceId(@PathVariable Integer id){
		logger.info("Info log of Main controller getbyId() called..");
		List<Citizen> citizens = service.getByVaccinatedServiceId(id);
		return new ResponseEntity<>(citizens,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Citizen> getByCitizenId(@PathVariable Integer id){
		logger.info("Info log of Main controller getbyId() called..");
		Citizen citizen = service.getByCitizenId(id);
		return new ResponseEntity<>(citizen,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCitizenById(@PathVariable Integer id){
		logger.info("Info log of Main controller deleteCitigenbyId() called..");
		service.deleteCitizenById(id);
		return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
	}
}
