package com.rtn.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RtnRequest {

	@NotNull
	@Column(name = "rtnDate")
	private Date rtnDate;
	@NotNull
	@Column(name = "rtnWhy")
	private String rtnWhy;
	@NotNull
	@Column(name = "refundAmount")
	private int refundAmount;
	
	@Max(3)
	@Min(0)
	@Column(name = "rtnStatus")
	private int rtnStatus;
//	// FK員工
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "empNo", referencedColumnName = "empNo")
//	private Emp empNo;
//	// FK訂單
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "orderNo", referencedColumnName = "ordNo")
//	private Order orderNo;

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

//	public Emp getEmpNo() {
//		return empNo;
//	}
//
//	public void setEmpNo(Emp empNo) {
//		this.empNo = empNo;
//	}
//
//	public Order getOrderNo() {
//		return orderNo;
//	}
//
//	public void setOrderNo(Order orderNo) {
//		this.orderNo = orderNo;
//	}

}
