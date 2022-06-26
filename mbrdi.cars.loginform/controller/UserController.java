package mbrdi.cars.loginform.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String getRegisterPage(){
        return "Register-page";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "Login-page";
    }


}
