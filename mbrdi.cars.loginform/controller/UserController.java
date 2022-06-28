package mbrdi.cars.LoginForm.controller;


import mbrdi.cars.LoginForm.model.UserModel;
import mbrdi.cars.LoginForm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UserModel());
        return "register_page";
    }


    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UserModel());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel){
        System.out.println("register request: "+userModel);
        UserModel registeredUser = userService.registerUser(userModel.getLogin(),userModel.getPassword(),userModel.getEmail());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model){
        System.out.println("login request: "+userModel);
        UserModel aunthenticated = userService.authenticate(userModel.getLogin(),userModel.getPassword());
        if(aunthenticated!=null){
            model.addAttribute("userLogin", aunthenticated.getLogin());
            return "car_models";
        }else{
            return "error_page";
        }
    }


}

