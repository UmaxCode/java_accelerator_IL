package com.umaxcode.simple_spring_mvc_app.controller;

import com.umaxcode.simple_spring_mvc_app.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String handleFormSubmission(@RequestParam("name") String name, Model model){
        User user = new User(name);
        model.addAttribute("user", user);
        return "greetings";
    }
}
