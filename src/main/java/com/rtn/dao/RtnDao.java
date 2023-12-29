package com.rtn.dao;

import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;

public interface RtnDao {

	Rtn getRtnNoById(Integer rtnNo);
	
	Integer createRtn(RtnRequest rtnRequest);
	
	void updateRtn(Integer RtnNoId , RtnRequest rtnRequest);
    
	Integer getAllRtnIdCount();
}
