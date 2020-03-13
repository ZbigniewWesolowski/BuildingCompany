package com.craftincode.buildingcompany.view;

import com.craftincode.buildingcompany.controller.dto.address.AddressDto;
import com.craftincode.buildingcompany.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressViewController {
    @Autowired
    AddressService addressService;

    @GetMapping("/addresses-table")
    public ModelAndView displayAccountTable() {
        ModelAndView mav = new ModelAndView("addresses-table");
        List<AddressDto> addressDtos = new ArrayList<>();
        addressDtos = addressService.getAllAddresses();
        mav.addObject("addressDtos", addressDtos);

        return mav;
    }
}
