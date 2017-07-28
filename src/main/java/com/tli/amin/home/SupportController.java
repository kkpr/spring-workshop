package com.tli.amin.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SupportController {

    @ModelAttribute("module")
    String module() {
        return "support";
    }

    @GetMapping("/support")
    String support() {
        return "home/support";
    }
}
