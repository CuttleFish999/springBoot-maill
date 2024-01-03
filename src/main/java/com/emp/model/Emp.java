package com.emp.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.empfun.model.EmpFun;

@Entity
@Table(name="emp")
public class Emp implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="empNo", updatable = false)
	private Integer empNo;
	
	@Column(name="empName")
	private String empName;
	
	@Column(name="empPsw", columnDefinition = "CHAR(45)")
	private String empPsw;
	
	@Column(name="empHireDate")
	private Date empHireDate;
	
	@Column(name="empStatus")
	private Byte empStatus;
	
	@Column(name="empSal")
	private Integer empSal;
	
//	@OneToMany(mappedBy = "emp", cascade = CascadeType.ALL)
//	private Set<EmpFun> empFun;
	
//	@OneToMany(mappedBy = "notice", cascade = CascadeType.ALL)
//	private Set<Notice> notice;
	
//	@OneToMany(mappedBy = "rentApp", cascade = CascadeType.ALL)
//	private Set<RentApp> rentApp;
	
//	@OneToMany(mappedBy = "lddApp", cascade = CascadeType.ALL)
//	private Set<LddApp> lddApp;
	
//	@OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
//	private Set<Report> report;
	
//	@OneToMany(mappedBy = "rtn", cascade = CascadeType.ALL)
//	private Set<Rtn> rtn;
	
//	@OneToMany(mappedBy = "pro", cascade = CascadeType.ALL)
//	private Set<Pro> pro;
	
	public Emp() {
		super();
	}
	
	
	
	public Emp(String empName, String empPsw, Date empHireDate, Byte empStatus, Integer empSal) {
		super();
		setEmpName(empName);
		setEmpPsw(empPsw);
		setEmpHireDate(empHireDate);
		setEmpStatus(empStatus);
		setEmpSal(empSal);
	}



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

//	public Set<EmpFun> getEmpFun() {
//		return empFun;
//	}
//
//	public void setEmpFun(Set<EmpFun> empFun) {
//		this.empFun = empFun;
//	}
	
}

