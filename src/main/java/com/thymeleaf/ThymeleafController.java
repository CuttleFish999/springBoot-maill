package com.thymeleaf;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rtn.contant.RtnCateGory;
import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;
import com.rtn.service.RtnService;

@Controller
@ComponentScan(basePackages = "com")
public class ThymeleafController {
	@Autowired
	public RtnService rtnService;
	
//	條件查詢:根據原因查詢
	@GetMapping("/Rtns")
	public ResponseEntity<List<Rtn>> getAllRtns
	(@RequestParam(required = false) RtnCateGory rtnCateGory
	) {
		List<Rtn> RtnList = rtnService.getAllRtns(rtnCateGory);

		return ResponseEntity.status(HttpStatus.OK).body(RtnList);
	}
	
	
	
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/Rtn")
	public String Rtn(Model model) {

//		取得所有Rtn資料
		Integer rtnCount = rtnService.getAllRtnIdCount();
		List<Rtn> rtn = rtnService.getAllRtnData();
//		注入QueryButtonEven資料
		
		List<String>QueryButtonValue = rtnService.getAllKeepRtnWhy();
		
		model.addAttribute("rtnCount", rtnCount);
		model.addAttribute("rtn1", rtn);
		model.addAttribute("QueryButtonValue", QueryButtonValue);
		return "Rtn";
	}

	@GetMapping("/Rtnmodify")
	public String updateProduct(@RequestParam(name = "rtnNo", required = false) Integer rtnNo, Model model) {
		if (rtnNo != null) {
			Rtn rtnPuting = rtnService.getProductById(rtnNo);
			model.addAttribute("rtnPuting", rtnPuting);
		}
		return "Rtnmodify";
	}
	
	@PutMapping("/Rtnmodify/{RtnNoId}")
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
	
	
	
//    @PutMapping("/Rtnmodify/{RtnNoId}")
//    public ResponseEntity<Rtn> updateProduct(@PathVariable Integer RtnNoId,
//    										 @RequestBody @Valid RtnRequest rtnRequeset){
////    	判斷數據是否存在
//    	Rtn rtn = rtnService.getProductById(RtnNoId);
////    	System.out.println(rtn);
//    	if(rtn == null) {
//    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    	}else {
////    		修改數據
//    		rtnService.updateRtn(RtnNoId, rtnRequeset);
//    		Rtn updatedRtn = rtnService.getProductById(RtnNoId);
//    		return ResponseEntity.status(HttpStatus.OK).body(updatedRtn);
//    	}
//    	
//    	return Rtnmodify
//	
//    }

//    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }
//
//    @PostMapping("/login")
//    public String login(String userName,
//                        String userPassword) {
//
//        System.out.println("userName 為: " + userName);
//        System.out.println("userPassword 為: " + userPassword);
//
//        return "login";
//    }
}
