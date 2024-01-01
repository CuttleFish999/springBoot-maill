package com.emp.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class EmpRegisterRequest {
//	@NotNull
	private Integer empNo;
//	@NotNull
	private String empName;
//	@NotNull
	private String empPsw;
//	@NotNull
	private Date empHireDate;

	private Byte empStatus;

	private Integer empSal;

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

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

	public Date getEmpHireDate() {
		return empHireDate;
	}

	public void setEmpHireDate(Date empHireDate) {
		this.empHireDate = empHireDate;
	}

	public Byte getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(Byte empStatus) {
		this.empStatus = empStatus;
	}

	public Integer getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Integer empSal) {
		this.empSal = empSal;
	}

}
