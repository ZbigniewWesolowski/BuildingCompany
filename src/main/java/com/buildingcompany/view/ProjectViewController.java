package com.buildingcompany.view;

import com.buildingcompany.controller.dto.project.ProjectDto;
import com.buildingcompany.controller.mapper.ProjectMapper;
import com.buildingcompany.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectViewController {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ProjectService projectService;
    @GetMapping ("/projects-table")
    public ModelAndView displayProjectsTable () {
        ModelAndView mav  = new ModelAndView("projects-table");
        List<ProjectDto> projectsDtos = new ArrayList<>();
        projectsDtos = projectService.getAll();
        mav.addObject("projectsDtos", projectsDtos);
        return mav;   }

}
