package com.buildingcompany.view;

import com.buildingcompany.controller.dto.salesDocument.SalesDocumentDto;
import com.buildingcompany.controller.dto.valuation.ValuationDto;
import com.buildingcompany.service.ValuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ValuationViewController {
    @Autowired
    ValuationService valuationService;

    @GetMapping("/valuations-table")
    public ModelAndView displayValuationTable() {
        ModelAndView mav = new ModelAndView("valuations-table");
        List<ValuationDto> valuationsDtos = new ArrayList<>();
        valuationsDtos = valuationService.getAllValuations();
        mav.addObject("valuationsDtos", valuationsDtos);

        return mav;

    }
}