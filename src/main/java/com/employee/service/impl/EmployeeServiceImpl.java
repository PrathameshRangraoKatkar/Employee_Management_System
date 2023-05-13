package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFOundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
@Autowired 
private EmployeeRepository employeeRepository ;
@Autowired
private EmployeeMapper employeeMapper;

public EmployeeDto creatEmployee (EmployeeDto employeeDto) {
	
	Employee employee=employeeMapper.tomEntry(employeeDto);
	
	Employee savedEmployee=employeeRepository.save(employee);
	return employeeMapper.toDto(savedEmployee);
}

public EmployeeDto updateEmployee(int id,EmployeeDto employeeDto) {
	Optional<Employee> opetionalEmployee= employeeRepository.findById(id);
	if(opetionalEmployee.isPresent()) {
		Employee employee=opetionalEmployee.get();
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		employee.setPhone(employeeDto.getPhone());
		employee.setAdress(employeeDto.getAdress());
		
		employee =employeeRepository.save(employee);
		return employeeMapper.toDto(employee);
		
		
	}
	else {
		throw new EmployeeNotFOundException(id);
	}
}
public void deleteEmployee(int id) {
	employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFOundException(id) );
	employeeRepository.deleteById(id);
}

public EmployeeDto getEmployeeById(int id) {
	Employee employee= employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFOundException(id));
	return employeeMapper.toDto(employee);
}

public List<EmployeeDto>getAllEmployees(){
	List<Employee> employees=employeeRepository.findAll();
	return employeeMapper.toDtoList(employees);
}
}
