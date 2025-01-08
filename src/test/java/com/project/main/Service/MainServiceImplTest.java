package com.project.main.Service;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.project.main.Entity.Citizen;
import com.project.main.Repo.CitizenRepo;

@SpringBootTest
public class MainServiceImplTest {
	
	@InjectMocks
	MainServiceImpl serviceImpl;
	
	@Mock
	CitizenRepo repo;
	
	@Test
	public void getByVaccinatedServiceIdTest() {
		when(repo.findByVaccinatedServiceId(1)).thenReturn(getEmployeeListStub());
		List<Citizen> list = serviceImpl.getByVaccinatedServiceId(1);
		Assertions.assertEquals(list.get(0).getEmail(), "dummy@gmail.com");
	}

	private List<Citizen> getEmployeeListStub(){
		List<Citizen> list = new ArrayList<Citizen>();
		Citizen emp = new Citizen();
		emp.setEmail("dummy@gmail.com");
		emp.setName("dummy");
		emp.setVaccinatedServiceId(1);
		list.add(emp);
		return list;
	}
//Changed for the commit in master
}
