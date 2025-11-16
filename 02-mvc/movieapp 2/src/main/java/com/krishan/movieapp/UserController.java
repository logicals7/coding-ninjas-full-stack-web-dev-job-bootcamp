package com.krishan.movieapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/signup")
    public String showSignupPage(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping("/register")
    public String registerUser(@ModelAttribute("user") User user){
        int id = userService.registerUser(user);
        if(id != -1){
            ModelAndView mv = new ModelAndView("redirect:movies/genre?username="+user.getUserName()+"&userId="+user.getId());
            return mv.getViewName();
        }
        return "/";
    }
}
