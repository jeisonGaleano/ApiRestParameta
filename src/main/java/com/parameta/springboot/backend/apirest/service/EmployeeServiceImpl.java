package com.parameta.springboot.backend.apirest.service;


import com.parameta.springboot.backend.apirest.integration.ClientService;
import com.parameta.springboot.backend.apirest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService{


	@Autowired
	private ClientService clientService;

	@Override
	public Employee findEmployee(Employee employee) throws Exception {
		 return clientService.saveEmployee(employee);
	}

}
