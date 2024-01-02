package com.emp.dao.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.emp.dao.EmpDao;
import com.emp.dto.EmpRegisterRequest;
import com.emp.model.Emp;
import com.emp.rowmapper.EmpRowMapper;

@Repository
public class EmpImpl implements EmpDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Emp getUserById(EmpRegisterRequest empRegisterRequest) {
		String sql = "SELECT empNo , empName , empPsw , empHireDate , empStatus , empSal " + 
					 "FROM emp" + " WHERE empName = :empName " + " AND empPsw = :empPsw ";
		System.out.println(sql);

		Map<String, Object> map = new HashMap<>();
		map.put("empName", empRegisterRequest.getEmpName());
		map.put("empPsw", empRegisterRequest.getEmpPsw());
		
		List<Emp> EmpList = namedParameterJdbcTemplate.query(sql, map, new EmpRowMapper());

		if (EmpList.size() > 0) {
				return EmpList.get(0);
			} else {
			return null;
		}
	}

	@Override
	public Integer createUser(EmpRegisterRequest empRegisterRequest) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Integer createUser(EmpRegisterRequest empRegisterRequest) {
//		String sql = "INSTER INTO emp(empNo , empName , empPsw , empHireDate , empStatus , empSal )"
//				+ "VALUE (:empNo , :empName , :empPsw , :empHireDate , :empStatus , :empSal)";
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("empNo", empRegisterRequest.getEmpNo());
//		map.put("empName", empRegisterRequest.getEmpName());
//		map.put("empPsw", empRegisterRequest.getEmpPsw());
//
//		Date now = new Date();
//		map.put("empHireDate", empRegisterRequest.getEmpHireDate());
//		map.put("empHireDate", now);
//
//		map.put("empStatus", empRegisterRequest.getEmpStatus());
//		map.put("empSal", empRegisterRequest.getEmpSal());
//
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//
//		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
//
//		int empNo = keyHolder.getKey().intValue();
//
//		return empNo;
//	}

}
