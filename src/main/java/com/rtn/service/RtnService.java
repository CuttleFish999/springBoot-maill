package com.rtn.service;

import java.util.List;

import com.rtn.contant.RtnCateGory;
import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;

public interface RtnService {
	
	public List<Rtn> getAllRtns(RtnCateGory rtnCateGory);

    Rtn getProductById(Integer productId);
    
    Integer createRtn(RtnRequest rtnRequeset);
    
    void updateRtn(Integer RtnNoId , RtnRequest rtnRequeset);
    
    Integer getAllRtnIdCount();
    
    List<Rtn> getAllRtnData();
}
