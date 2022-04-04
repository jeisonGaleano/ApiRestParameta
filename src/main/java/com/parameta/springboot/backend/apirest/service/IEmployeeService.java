package com.parameta.springboot.backend.apirest.service;

import com.parameta.springboot.backend.apirest.model.Employee;


public interface IEmployeeService {

	public Employee findEmployee(Employee empleado) throws Exception;
	
	
}
