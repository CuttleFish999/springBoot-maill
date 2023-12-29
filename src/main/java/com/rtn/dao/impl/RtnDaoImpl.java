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
import com.rtn.dto.RtnRequest;
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
		String sqlTest = "SELECT rtnNo, rtnDate, rtnWhy, refundAmount, rtnStatus "
				+ "FROM rtn WHERE rtnNo =:rtnNo";
		
		Map<String , Object> map = new HashMap<>();
		map.put("rtnNo", rtnNo);
		
		List<Rtn> RtnList = namedParameterJdbcTemplate.query(sqlTest,map,new RtnRowMapper());
		
		if(RtnList.size() > 0) {
			return RtnList.get(0);
		}else {
			return null;
		}
		
	}

	@Override
	public Integer createRtn(RtnRequest rtnRequest) {
		String sql = "INSERT INTO RTN (  rtnWhy , refundAmount , rtnStatus , rtnDate)" +
					"VALUE( :rtnWhy , :refundAmount , :rtnStatus , :rtnDate )";
		Map<String , Object> map = new HashMap<>();
		
		map.put("rtnWhy", rtnRequest.getRtnWhy());
		map.put("refundAmount", rtnRequest.getRefundAmount());
		map.put("rtnStatus", rtnRequest.getRtnStatus());
		
		Date now = new Date();
		map.put("rtnDate", now);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);
		
		
		int RtnNoId = keyHolder.getKey().intValue();
		
		
		return RtnNoId;
	}

	@Override
	public void updateRtn(Integer RtnNoId, RtnRequest rtnRequest) {
		String sql = "UPDATE rtn SET  rtnWhy = :rtnWhy , refundAmount = :refundAmount ,  rtnStatus = :rtnStatus ,rtnDate = :rtnDate "  +
		"WHERE rtnNo = :RtnNoId";
		
		Map<String , Object> map = new HashMap<>();
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
	
	
	
	
}
