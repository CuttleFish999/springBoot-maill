package com.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rtn.model.Rtn;
import com.rtn.service.RtnService;

@Controller
@ComponentScan(basePackages = "com")
public class ThymeleafController {
	@Autowired
	public RtnService rtnService;

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

    @GetMapping("/Rtn")
	public String Rtn(Model model) {

		Integer rtnCount = rtnService.getAllRtnIdCount();
		List<Rtn> rtn = rtnService.getAllRtnData();
		model.addAttribute("rtnCount", rtnCount);
		model.addAttribute("rtn1", rtn);
		return "Rtn";
	}
    
    @GetMapping("/Rtnmodify/{RtnNoid}")
    public String updateProduct(@PathVariable Integer RtnNoId,
    							Model model) {
    	
    	Rtn rtnPuting = rtnService.getProductById(RtnNoId);
    	
    	model.addAttribute("rtnPuting",rtnPuting);
    	
    	return "Rtnmodify";
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
