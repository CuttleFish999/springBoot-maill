package com.rtn.service;

import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;

public interface RtnService {

    Rtn getProductById(Integer productId);
    
    Integer createRtn(RtnRequest rtnRequeset);
    
    void updateRtn(Integer RtnNoId , RtnRequest rtnRequeset);
    
    Integer getAllRtnIdCount();
}
