package com.rtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rtn.model.Rtn;
import com.rtn.service.RtnService;

@RestController
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
}
