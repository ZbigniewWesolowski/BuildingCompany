package com.craftincode.buildingcompany.view;

import com.craftincode.buildingcompany.controller.dto.address.AddressDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@Controller
public class HomepageViewController {
    @GetMapping("/homepage")
    public ModelAndView displayHomepage() {
        ModelAndView mav = new ModelAndView("homepage");
        return mav;
    }
}
