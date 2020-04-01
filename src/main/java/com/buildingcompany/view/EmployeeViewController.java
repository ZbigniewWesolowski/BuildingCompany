package com.buildingcompany.view;

import com.buildingcompany.controller.dto.employee.EmployeeDto;
import com.buildingcompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeViewController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees-table")
    public ModelAndView displayEmployessTable() {
        ModelAndView mav = new ModelAndView("employees-table");
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        employeeDtos = employeeService.getAllEmployees();
        mav.addObject("employeeDtos", employeeDtos);
        return mav;
    }
}



