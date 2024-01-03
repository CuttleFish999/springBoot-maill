package com.rtn.rowmapper;

import com.rtn.model.Rtn;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.emp.model.*;
public class RtnRowMapper implements RowMapper<Rtn> {
    @Override
    public Rtn mapRow(ResultSet resultSet, int i) throws SQLException {
    	
    	Rtn rtn = new Rtn();      
        rtn.setRtnNo(resultSet.getInt("rtnNo"));
//        rtn.setEmpNo(resultSet.getInt("empNo"));
//        rtn.setOrdNo(resultSet.getInt("ordNo"));
        rtn.setRtnDate(resultSet.getDate("rtnDate"));
        rtn.setRtnWhy(resultSet.getString("rtnWhy"));
        rtn.setRefundAmount(resultSet.getInt("refundAmount"));
        rtn.setRtnStatus(resultSet.getInt("rtnStatus"));
        
        Emp emp = new Emp();
        emp.setEmpNo(resultSet.getInt("empNo"));
        rtn.setEmpNo(emp);
        
//        Ord ord = new Ord();
//        emp.setEmpNo(resultSet.getInt("empNo"));
//        rtn.setEmpNo(emp);
        

        
        return rtn;
    }
}
