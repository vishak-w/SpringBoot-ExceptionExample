package com.exlogutest.exceptionExample;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

class ServiceTest extends ExceptionExampleApplicationTests{
	
	@InjectMocks
	EmpService empservice;
	@Mock
	ServiceRepo servRepo;
	
	
	
	@Test
	void saveTest() throws CustomException
	{
		Integer id=1;
		Employee emp=new Employee();
		List<Employee> list=new ArrayList<Employee>();
		/*
		 * emp.setId(1); emp.setName("vishak"); emp.setAge(28); emp.setRole("sf");
		 * list.add(emp);
		 */
		//servRepo.save(emp);
		assertNotNull(emp.toString());
		
		when(servRepo.findAll()).thenReturn(list);
		when(servRepo.findById(id)).thenReturn(Optional());
		assertEquals(list,servRepo.findAll());
		
	}



	private Optional<Employee> Optional() {
		// TODO Auto-generated method stub
		return null;
	}

}
