package com.quizApp.quizApplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CommonController {

    @RequestMapping("/")
    public ModelAndView index() {
        return  new ModelAndView("index.html");
    }

//    @RequestMapping("/error")
//    public ModelAndView error() {
//        return  new ModelAndView("error.html");
//    }
}
