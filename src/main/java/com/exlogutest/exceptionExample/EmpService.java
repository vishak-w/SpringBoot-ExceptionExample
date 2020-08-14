package com.exlogutest.exceptionExample;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
	@Autowired
	ServiceRepo serviceRepo;

	public Employee saveEmp(Employee emp) {
		return serviceRepo.save(emp);
	}

	public Employee findById(Integer id) {
		Optional<Employee> find = serviceRepo.findById(id);
		if (find.isPresent())
			return find.get();
		else

			return null;
	}

	public List<Employee> showAll(Integer pageNo,Integer pageSize,String sortBy) throws CustomException {
		Pageable paging=PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Employee> find = serviceRepo.findAll(paging);
		if (find.hasContent())
			return find.getContent();
			
		else
			throw new CustomException("Employee Not Found");
	}

}
