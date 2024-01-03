package com.emp.service;

import com.emp.dto.EmpRegisterRequest;
import com.emp.model.Emp;

public interface EmpService  {
	Emp getUserById(EmpRegisterRequest empRegisterRequest);
}
