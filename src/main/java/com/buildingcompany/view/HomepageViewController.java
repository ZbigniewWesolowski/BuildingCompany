package com.buildingcompany.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageViewController {
    @GetMapping("/homepage")
    public ModelAndView displayHomepage() {
        ModelAndView mav = new ModelAndView("homepage");
        return mav;
    }
}
