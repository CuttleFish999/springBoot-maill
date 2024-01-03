package com.rtn.service;

import java.util.List;

import com.rtn.dto.RtnQueryParams;
import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;

public interface RtnService {
	
//	Rtn選單value注入功能
	List<String> getAllKeepRtnWhy();
	
	public List<Rtn> getAllRtns(RtnQueryParams rtnQueryParams);

    Rtn getProductById(Integer productId);
    
    Integer createRtn(RtnRequest rtnRequeset);
    
    void updateRtn(Integer RtnNoId , RtnRequest rtnRequeset);
    
    Integer getAllRtnIdCount();
    
    List<Rtn> getAllRtnData();
}
