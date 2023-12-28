package com.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rtn.model.Rtn;

@Controller
public class ThymeleafController {

    @GetMapping("/home")
    public String home(Model model) {
//        Student student = new Student();
//        student.setId(1);
//        student.setName("Judy");
        
//        Rtn rtn = new Rtn();
//        rtn.setRtnNo(1);
//        rtn.set
        
//        model.addAttribute("myStudent", student);

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
