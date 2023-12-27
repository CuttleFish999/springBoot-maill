package com.rtn.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.rtn.dao.RtnDao;
import com.rtn.model.Rtn;
import com.rtn.rowmapper.RtnRowMapper;

@Component
public class RtnDaoImpl implements RtnDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Rtn getRtnNoById(Integer rtnNo) {
//		String sql = "SELECT rtnNo, empNo, ordNo, rtnDate, rtnWhy, refundAmount, rtnStatus "
//				+ "FROM rtn WHERE rtnNo =:rtnNo";
//		String sqlTest = "SELECT rtnNo, rtnDate, rtnWhy, refundAmount, rtnStatus "
//				+ "FROM rtn WHERE rtnNo =:rtnNo";
//		String sqlTestEmp = "SELECT rtnNo, empNo, rtnDate, rtnWhy, refundAmount, rtnStatus "
//				+ "FROM rtn WHERE rtnNo =:rtnNo";
		
		String sqlTestEmp = "SELECT "
				+ "    r.rtnNo, "
				+ "    r.rtnDate, "
				+ "    r.rtnWhy, "
				+ "    r.refundAmount, "
				+ "    r.rtnStatus, "
				+ "    e.empNo, "
				+ "    e.empName, "
				+ "    e.empPsw, "
				+ "    e.empHireDate, "
				+ "    e.empStatus, "
				+ "    e.empSal "
				+ "FROM "
				+ "    rtn r "
				+ "JOIN "
				+ "    emp e "
				+ "ON "
				+ "    r.empNo = e.empNo "
				+ "WHERE "
				+ "    r.rtnNo =:rtnNo; ";

		Map<String, Object> map = new HashMap<>();
		map.put("rtnNo", rtnNo);
		List<Rtn> RtnList = namedParameterJdbcTemplate.query(sqlTestEmp, map, new RtnRowMapper());

		if (RtnList.size() > 0) {
			return RtnList.get(0);
		} else {
			return null;
		}

	}
}
