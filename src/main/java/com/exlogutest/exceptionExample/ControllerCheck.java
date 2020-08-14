package com.exlogutest.exceptionExample;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/employee")
@RestController
public class ControllerCheck {

	public final Logger logger = Logger.getLogger(ControllerCheck.class);
	private static final String reg_expression = "\n\n\n\t\t\t";

	@Autowired
	EmpService empService;

	@PostMapping(value = "/save")
	public ResponseEntity<Employee> saveEmployee(Employee emp) throws CustomException {
		Employee saved = empService.saveEmp(emp);
		logger.info("Storing Employee Object with {id},{name},{age},and {role} parameters...Storing in Progress....."
				+ reg_expression + saved.toString() + "..Record Saved Successfully");
		// logger.info(saved.toString());
		return new ResponseEntity<Employee>(saved, new HttpHeaders(), HttpStatus.OK);

	}

	@GetMapping(value = "/showAll")
	public ResponseEntity<List<Employee>> showAll(@RequestParam Integer pageNo, @RequestParam Integer pagesize,
			@RequestParam(defaultValue = "id") String sortBy) throws CustomException {

		List<Employee> list = empService.showAll(pageNo, pagesize, sortBy);
		logger.info("Getting All Employee Details..From Controller showAll() method" + list);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);

	}
}
