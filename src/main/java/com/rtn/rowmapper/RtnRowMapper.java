package com.rtn.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emp.model.Emp;
import com.rtn.model.Rtn;

public class RtnRowMapper implements RowMapper<Rtn> {
    @Override
    public Rtn mapRow(ResultSet resultSet, int i) throws SQLException {
    	
    	Rtn rtn = new Rtn();      
        rtn.setRtnNo(resultSet.getInt("rtnNo"));
        
        Emp emp = new Emp(); 
        emp.setEmpNo(resultSet.getInt("empNo"));
        emp.setEmpName(resultSet.getString("empName"));
        emp.setEmpPsw(resultSet.getString("empPsw"));
        emp.setEmpHireDate(resultSet.getDate("empHireDate"));
        emp.setEmpStatus(resultSet.getByte("empStatus"));
        emp.setEmpSal(resultSet.getInt("empSal"));
        
        rtn.setEmpNo(emp); 
        
        
//        rtn.setEmpNo(resultSet.getInt("empNo"));
//        rtn.setOrdNo(resultSet.getInt("ordNo"));
        rtn.setRtnDate(resultSet.getDate("rtnDate"));
        rtn.setRtnWhy(resultSet.getString("rtnWhy"));
        rtn.setRefundAmount(resultSet.getInt("refundAmount"));
        rtn.setRtnStatus(resultSet.getInt("rtnStatus"));
        
        return rtn;
    }
}
