package com.buildingcompany.controller.mapper;

import com.buildingcompany.model.Material;
import com.buildingcompany.model.Project;
import com.buildingcompany.repository.*;
import com.buildingcompany.controller.dto.project.CreateUpdateProjectDto;
import com.buildingcompany.controller.dto.project.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ValuationRepository valuationRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private SalesDocumentRepository salesDocumentRepository;
    @Autowired
    private AddressRepository addressRepository;

    public ProjectDto fromEntityToDto(Project project) {
        List<Integer> materialListId = project.getMaterialList().stream()
                .map(material -> material.getId())
                .collect(Collectors.toList());
        return ProjectDto.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .status(project.getStatus())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .employeeId(project.getEmployee().getId())
                .valuationId(project.getValuation().getId())
                .materialListId(materialListId)
                .salesDocumentId(project.getSalesDocument().getId())
                .addressId(project.getAddress().getId())
                .build();
    }

    public Project toEntity(CreateUpdateProjectDto createUpdateProjectDto) {
        List<Material> materials
                = createUpdateProjectDto.getMaterialListId().stream()
                .map(id -> materialRepository.findById(id).get())
                .collect(Collectors.toList());
        return Project.builder()
                .status(createUpdateProjectDto.getStatus())
                .employee(employeeRepository.findById(createUpdateProjectDto.getEmployeeId()).get())
                .valuation(valuationRepository.findById(createUpdateProjectDto.getValuationId()).get())
                .materialList(materials)
                .salesDocument(salesDocumentRepository.findById(createUpdateProjectDto.getSalesDocumentId()).get())
                .address(addressRepository.findById(createUpdateProjectDto.getAddressId()).get())
                .build();

    }
}