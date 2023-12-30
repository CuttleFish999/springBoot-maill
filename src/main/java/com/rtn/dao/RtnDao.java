package com.rtn.dao;

import java.util.List;

import com.rtn.contant.RtnCateGory;
import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;

public interface RtnDao {
	
	List<Rtn> getAllRtns(RtnCateGory RtnCateGory);
	
	Rtn getRtnNoById(Integer rtnNo);
	
	Integer createRtn(RtnRequest rtnRequest);
	
	void updateRtn(Integer RtnNoId , RtnRequest rtnRequest);
    
	Integer getAllRtnIdCount();
	
	List<Rtn> getAllRtnData();
}