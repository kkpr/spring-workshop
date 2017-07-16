package com.tli.amin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    /**
     * This method will greet users.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index() {
        return "welcome";
    }

    /**
     * This method will greet users.
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String home() {
        return "home";
    }

}
