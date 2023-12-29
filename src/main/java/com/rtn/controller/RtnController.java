package com.rtn.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;
import com.rtn.service.RtnService;

//@RestController
public class RtnController {

    @Autowired
    private RtnService rtnService;


    @GetMapping("/Rtn/{rtnNo}")
    public ResponseEntity<Rtn> getProduct(@PathVariable Integer rtnNo){
    	Rtn rtn = rtnService.getProductById(rtnNo);

        if(rtn != null){
            return ResponseEntity.status(HttpStatus.OK).body(rtn);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PostMapping("/Rtn")
    public ResponseEntity<Rtn> createRtn(@RequestBody @Valid RtnRequest rtnRequest){
		
    	Integer RtnNoId = rtnService.createRtn(rtnRequest);
    	
    	Rtn rtn = rtnService.getProductById(RtnNoId);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(rtn);
    	
    }
    
    @PutMapping("/Rtn/{RtnNoId}")
    public ResponseEntity<Rtn> updateProduct(@PathVariable Integer RtnNoId,
    										 @RequestBody @Valid RtnRequest rtnRequeset){
//    	判斷數據是否存在
    	Rtn rtn = rtnService.getProductById(RtnNoId);
    	System.out.println(rtn == null);
    	if(rtn == null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}else {
//    		修改數據
    		rtnService.updateRtn(RtnNoId, rtnRequeset);
    		Rtn updatedRtn = rtnService.getProductById(RtnNoId);
    		System.out.println(RtnNoId);
    		return ResponseEntity.status(HttpStatus.OK).body(updatedRtn);
    	}
    	
	
    }
}
