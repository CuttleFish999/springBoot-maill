package com.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rtn.model.Rtn;
import com.rtn.service.RtnService;

@Controller
@ComponentScan(basePackages = "com.rtn")
public class ThymeleafController {
	@Autowired
	public RtnService rtnService;
	
    @GetMapping("/")
    public String home(Model model) {

    	Integer rtnCount = rtnService.getAllRtnIdCount();
//        Rtn rtn = rtnService.getProductById(1);
        List<Rtn> rtn = rtnService.getAllRtnData();
        model.addAttribute("rtnCount", rtnCount);
        model.addAttribute("rtn1",rtn);
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public String login(String userName,
                        String userPassword) {

        System.out.println("userName 為: " + userName);
        System.out.println("userPassword 為: " + userPassword);

        return "login";
    }
}
