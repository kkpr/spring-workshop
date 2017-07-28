package com.tli.amin.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PricingController {

    @ModelAttribute("module")
    String module() {
        return "pricing";
    }

    @GetMapping("/pricing")
    String pricing() {
        return "home/pricing";
    }
}
