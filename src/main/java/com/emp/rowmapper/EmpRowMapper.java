package com.emp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emp.model.Emp;

public class EmpRowMapper implements RowMapper<Emp>{

	@Override
	public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
		Emp emp = new Emp();
		
		emp.setEmpNo(rs.getInt("empNo"));
		emp.setEmpName(rs.getString("empName"));
		emp.setEmpPsw(rs.getString("empPsw"));
		emp.setEmpHireDate(rs.getDate("empHireDate"));
		emp.setEmpStatus(rs.getByte("empStatus"));
		emp.setEmpSal(rs.getInt("empSal"));
	
		return emp;
	}
	
}
