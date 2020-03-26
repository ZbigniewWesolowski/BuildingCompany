package com.craftincode.buildingcompany.view;

import com.craftincode.buildingcompany.controller.dto.address.AddressDto;
import com.craftincode.buildingcompany.controller.dto.customer.CustomerDto;
import com.craftincode.buildingcompany.service.AddressService;
import com.craftincode.buildingcompany.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerViewController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers-table")
    public ModelAndView displayCustomersTable() {
        ModelAndView mav = new ModelAndView("customers-table");
        List<CustomerDto> customerDtos = new ArrayList<>();
        customerDtos = customerService.getAllCustomers();
        mav.addObject("customerDtos", customerDtos);

        return mav;
    }
}

