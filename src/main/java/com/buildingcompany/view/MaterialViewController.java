package com.buildingcompany.view;

import com.buildingcompany.controller.dto.material.MaterialDto;
import com.buildingcompany.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MaterialViewController {
    @Autowired
    MaterialService materialService;
@GetMapping ("/materials-table")
    public ModelAndView displayMaterialsTable () {
    ModelAndView mav =new ModelAndView("materials-table");
    List<MaterialDto> materialDtos = new ArrayList<>();
    materialDtos = materialService.getAllMaterials();
    mav.addObject("materialDtos", materialDtos);
    return mav;
}
}
