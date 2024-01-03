package com.emp.dao;

import com.emp.dto.EmpRegisterRequest;
import com.emp.model.Emp;

public interface EmpDao {
	Emp getUserById(EmpRegisterRequest empRegisterRequest);
	
	Integer createUser(EmpRegisterRequest empRegisterRequest);
}
