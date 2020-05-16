package com.buildingcompany.view;

import com.buildingcompany.controller.dto.customer.CustomerDto;
import com.buildingcompany.controller.dto.salesDocument.SalesDocumentDto;
import com.buildingcompany.service.SalesDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SalesDocumentViewController {
    @Autowired
    SalesDocumentService salesDocumentService;

    @GetMapping ("/sales-document-table")
    public ModelAndView dispalySalesDocumentTable() {
        ModelAndView mav = new ModelAndView("sales-document-table");
        List<SalesDocumentDto> salesDocumentDtos = new ArrayList<>();
        salesDocumentDtos = salesDocumentService.getAllSalesDocuments();
        mav.addObject("salesDocumentDtos", salesDocumentDtos);

        return mav;
    }
}