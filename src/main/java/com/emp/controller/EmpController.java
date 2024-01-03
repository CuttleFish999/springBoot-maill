package com.emp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dto.EmpRegisterRequest;
import com.emp.model.Emp;
import com.emp.service.EmpService;

//@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@PostMapping("Emp/register")
	public ResponseEntity<Emp> register(@RequestBody @Valid EmpRegisterRequest empRegisterRequest){
		
		Emp empName = empService.getUserById(empRegisterRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(empName);
	}
}
