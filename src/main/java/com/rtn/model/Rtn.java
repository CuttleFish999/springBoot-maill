package com.rtn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.criterion.Order;

import com.emp.model.Emp;

@Entity
@Table(name = "Rtn")
public class Rtn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rtnNo", updatable = false)
	private Integer rtnNo;

	// FK員工
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empNo", referencedColumnName = "empNo")
	private Emp empNo;
	// FK訂單
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderNo", referencedColumnName = "ordNo")
	private Order orderNo;
	
	@Column(name = "rtnDate")
	private Date rtnDate;

	@Column(name = "rtnWhy")
	private String rtnWhy;

	@Column(name = "refundAmount")
	private int refundAmount;
	
	@Max(3)
	@Min(0)
	@Column(name = "rtnStatus")
	private int rtnStatus;

	public Integer getRtnNo() {
		return rtnNo;
	}

	public void setRtnNo(Integer rtnNo) {
		this.rtnNo = rtnNo;
	}

	public Date getRtnDate() {
		return rtnDate;
	}

	public void setRtnDate(Date rtnDate) {
		this.rtnDate = rtnDate;
	}

	public String getRtnWhy() {
		return rtnWhy;
	}

	public void setRtnWhy(String rtnWhy) {
		this.rtnWhy = rtnWhy;
	}

	public int getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}

	public int getRtnStatus() {
		return rtnStatus;
	}

	public void setRtnStatus(int rtnStatus) {
		this.rtnStatus = rtnStatus;
	}

	public Emp getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Emp empNo) {
		this.empNo = empNo;
	}

	public Order getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Order orderNo) {
		this.orderNo = orderNo;
	}

}
