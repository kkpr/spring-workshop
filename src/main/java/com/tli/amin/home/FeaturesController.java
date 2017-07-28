package com.tli.amin.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class FeaturesController {

    @ModelAttribute("module")
    String module() {
        return "features";
    }

    @GetMapping("/features")
    String features() {
        return "home/features";
    }
}
