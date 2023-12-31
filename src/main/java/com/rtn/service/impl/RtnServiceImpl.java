package com.rtn.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rtn.dao.RtnDao;
import com.rtn.dto.RtnQueryParams;
import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;
import com.rtn.service.RtnService;

@Component
public class RtnServiceImpl implements RtnService {

    @Autowired
    private RtnDao rtnDao;
    
    
    
    
    @Override
	public List<Rtn> getAllRtns(RtnQueryParams rtnQueryParams) {
		return rtnDao.getAllRtns(rtnQueryParams);
	}
    
//	Rtn選單value注入功能
    public List<String> getAllKeepRtnWhy() {
		return rtnDao.getAllKeepRtnWhy();
	}
    
	@Override
    public Rtn getProductById(Integer rtnNo) {
        return rtnDao.getRtnNoById(rtnNo);
    }
	@Override
	public Integer createRtn(RtnRequest rtnRequeset) {
		return rtnDao.createRtn(rtnRequeset);
		
	}
	@Override
	public void updateRtn(Integer RtnNoId, RtnRequest rtnRequeset) {
		rtnDao.updateRtn(RtnNoId, rtnRequeset);
	}
	@Override
	public Integer getAllRtnIdCount() {
		
		return rtnDao.getAllRtnIdCount();
	}
	@Override
	public List<Rtn> getAllRtnData() {
		return rtnDao.getAllRtnData();
	}
}
