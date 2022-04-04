package com.parameta.springboot.backend.apirest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parameta.springboot.backend.apirest.model.Employee;
import com.parameta.springboot.backend.apirest.service.IEmployeeService;
import com.parameta.springboot.backend.apirest.util.Functions;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<?> getEmployees(@Valid @RequestBody Employee employee) throws Exception{
		

			 if(!Functions.validateAge(employee.getDateBirthday())) {
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						 .body("El empleado no cumple con ser mayor de edad");
			 }

			 return  ResponseEntity.status(HttpStatus.CREATED)
				.body(	employeeService.findEmployee(employee));

	}
}
