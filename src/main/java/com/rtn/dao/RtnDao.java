package com.rtn.dao;

import java.util.List;

import com.rtn.dto.RtnQueryParams;
import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;

public interface RtnDao {
	
//	Rtn選單value注入功能
	List<String> getAllKeepRtnWhy();
	
	List<Rtn> getAllRtns(RtnQueryParams rtnQueryParams);
		
	Rtn getRtnNoById(Integer rtnNo);
	
	Integer createRtn(RtnRequest rtnRequest);
	
	void updateRtn(Integer RtnNoId , RtnRequest rtnRequest);
    
	Integer getAllRtnIdCount();
	
	List<Rtn> getAllRtnData();
}
