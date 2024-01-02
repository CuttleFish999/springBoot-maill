package com.emp.dto;

import javax.validation.constraints.NotNull;

public class EmpRegisterRequest {

	@NotNull
	private String empName;

	@NotNull
	private String empPsw;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPsw() {
		return empPsw;
	}

	public void setEmpPsw(String empPsw) {
		this.empPsw = empPsw;
	}
}
