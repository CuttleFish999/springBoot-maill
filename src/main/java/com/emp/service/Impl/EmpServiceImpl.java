package com.emp.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.EmpDao;
import com.emp.dto.EmpRegisterRequest;
import com.emp.model.Emp;
import com.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDao empDao;
	
	@Override
	public Emp getUserById(EmpRegisterRequest empRegisterRequest) {
		
		return empDao.getUserById(empRegisterRequest);
	}
	
}
