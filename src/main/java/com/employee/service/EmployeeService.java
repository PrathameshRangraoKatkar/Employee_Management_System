package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto creatEmployee (EmployeeDto employeeDto);
	
	
	EmployeeDto updateEmployee(int id,EmployeeDto employeeDto);

	
	void deleteEmployee(int id);
	
	EmployeeDto getEmployeeById(int id);
	
	List<EmployeeDto>getAllEmployees();
	
}
