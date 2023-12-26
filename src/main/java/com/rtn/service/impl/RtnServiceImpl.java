package com.rtn.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rtn.dao.RtnDao;
import com.rtn.model.Rtn;
import com.rtn.service.RtnService;

@Component
public class RtnServiceImpl implements RtnService {

    @Autowired
    private RtnDao rtnDao;
    @Override
    public Rtn getProductById(Integer rtnNo) {
        return rtnDao.getRtnNoById(rtnNo);
    }
}
