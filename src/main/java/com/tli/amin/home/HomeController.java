package com.tli.amin.home;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.logging.Logger;

@Controller
public class HomeController {

    @ModelAttribute("module")
    String module() {
        return "home";
    }

    @GetMapping("/")
    String index(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }


}
