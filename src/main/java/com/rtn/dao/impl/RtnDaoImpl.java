package com.rtn.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.rtn.dao.RtnDao;
import com.rtn.dto.RtnQueryParams;
import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;
import com.rtn.rowmapper.RtnRowMapper;

@Component
public class RtnDaoImpl implements RtnDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Rtn> getAllRtns(RtnQueryParams rtnQueryParams) {
		String sql = "SELECT rtnNo, empNo, ordNo, rtnDate, rtnWhy, refundAmount, rtnStatus " + "FROM rtn WHERE 1=1";
		Map<String, Object> map = new HashMap<>();
		
		sql = addFilteringSQL(sql, map, rtnQueryParams);
		
		System.out.println("addFilteringSQL: " + (sql));
		
		List<Rtn> RtnList = namedParameterJdbcTemplate.query(sql, map, new RtnRowMapper());

		return RtnList;
	}

//	Rtn選單value注入功能
	@Override
	public List<String> getAllKeepRtnWhy() {
		String sql = "SELECT DISTINCT rtnWhy FROM rtn";

		return namedParameterJdbcTemplate.queryForList(sql, new HashMap<>(), String.class);
	}

	@Override
	public Rtn getRtnNoById(Integer rtnNo) {
		String sql = "SELECT rtnNo, empNo, ordNo, rtnDate, rtnWhy, refundAmount, rtnStatus "
				+ "FROM rtn WHERE rtnNo =:rtnNo";
//		String sql = "SELECT rtnNo, rtnDate, rtnWhy, refundAmount, rtnStatus "
//				+ "FROM rtn WHERE rtnNo =:rtnNo";

		Map<String, Object> map = new HashMap<>();
		map.put("rtnNo", rtnNo);

		List<Rtn> RtnList = namedParameterJdbcTemplate.query(sql, map, new RtnRowMapper());

		if (RtnList.size() > 0) {
			return RtnList.get(0);
		} else {
			return null;
		}

	}

	@Override
	public Integer createRtn(RtnRequest rtnRequest) {
		String sql = "INSERT INTO RTN (  rtnWhy , refundAmount , rtnStatus , rtnDate)"
				+ "VALUE( :rtnWhy , :refundAmount , :rtnStatus , :rtnDate )";
		Map<String, Object> map = new HashMap<>();

		map.put("rtnWhy", rtnRequest.getRtnWhy());
		map.put("refundAmount", rtnRequest.getRefundAmount());
		map.put("rtnStatus", rtnRequest.getRtnStatus());

		Date now = new Date();
		map.put("rtnDate", now);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

		int RtnNoId = keyHolder.getKey().intValue();

		return RtnNoId;
	}

	@Override
	public void updateRtn(Integer RtnNoId, RtnRequest rtnRequest) {
		String sql = "UPDATE rtn SET  rtnWhy = :rtnWhy , refundAmount = :refundAmount ,  rtnStatus = :rtnStatus ,rtnDate = :rtnDate "
				+ "WHERE rtnNo = :RtnNoId";

		Map<String, Object> map = new HashMap<>();
		map.put("RtnNoId", RtnNoId);

		map.put("rtnWhy", rtnRequest.getRtnWhy());
		map.put("refundAmount", rtnRequest.getRefundAmount());
		map.put("rtnStatus", rtnRequest.getRtnStatus());

		map.put("rtnDate", rtnRequest.getRtnDate());

		namedParameterJdbcTemplate.update(sql, map);
	}

	@Override
	public Integer getAllRtnIdCount() {
		String sql = "SELECT COUNT(*) FROM RTN;";
		return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource(), Integer.class);
	}

	@Override
	public List<Rtn> getAllRtnData() {
		String sql = "SELECT rtnNo ,empNo,ordNo,rtnDate,rtnWhy,refundAmount,rtnStatus FROM rtn;";

		Map<String, Object> map = new HashMap<>();

		List<Rtn> RtnList = namedParameterJdbcTemplate.query(sql, map, new RtnRowMapper());

		if (RtnList.size() > 0) {
			return RtnList;
		} else {
			return null;
		}

	}

	public String addFilteringSQL(String sql, Map<String, Object> map, RtnQueryParams rtnQueryParams) {
	    if (rtnQueryParams.getRtnCateGory() != null) {
	        System.out.println("rtnQueryParams.getRtnCateGory(): " + rtnQueryParams.getRtnCateGory());
	        System.out.println("getRtnCateGory: " + (rtnQueryParams.getRtnCateGory() != null));

	        sql += " AND rtnWhy = :rtnWhy";

	        System.out.println("getRtnCateGory sql: " + sql);

	        map.put("rtnWhy", rtnQueryParams.getRtnCateGory().name());
	    }



//		if (rtnQueryParams.getSearch() != null) {
//			
//			System.out.println("rtnWhy: " + (rtnQueryParams.getSearch() != null));
//			
//			sql += " AND rtnWhy = :rtnWhy";
//			
//			System.out.println("rtnWhy sql: " + sql);
//			
//			map.put("search", "%" + rtnQueryParams.getRtnDate() + "%");
//		}

		return sql;
	}
}
