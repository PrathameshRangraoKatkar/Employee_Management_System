package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFOundException  extends RuntimeException{

	public EmployeeNotFOundException(int id) {
		super("Employee not found with id"+ id);
	}
}
