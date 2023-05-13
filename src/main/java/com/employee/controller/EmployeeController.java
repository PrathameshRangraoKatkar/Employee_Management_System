package com.employee.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
  @Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee (@Valid @RequestBody EmployeeDto employeeDto){

	try{

	EmployeeDto createdEmployee = employeeService.creatEmployee ( employeeDto);

	URI Location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")

	.buildAndExpand (createdEmployee.getEmail()).toUri();

	return ResponseEntity.created(Location).body(createdEmployee);
	}

	catch (Exception e){

	throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while creating the employee",e);

	}
}
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto>updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeDto){
		EmployeeDto updateedEmployee=employeeService.updateEmployee(id, employeeDto);
		return ResponseEntity.ok(updateedEmployee);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable int id){
		EmployeeDto employeeDto=employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employeeDto);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto>employees=employeeService.getAllEmployees();
	    return ResponseEntity.ok(employees);
	}
	}
