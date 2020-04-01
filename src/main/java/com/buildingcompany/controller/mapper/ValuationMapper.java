package com.buildingcompany.controller.mapper;

import com.buildingcompany.repository.CustomerRepository;
import com.buildingcompany.controller.dto.valuation.CreateUpdateValuationDto;
import com.buildingcompany.controller.dto.valuation.ValuationDto;
import com.buildingcompany.model.Valuation;
import com.buildingcompany.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValuationMapper {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public ValuationDto fromEntitytoDto(Valuation valuation) {
        return ValuationDto.builder()
                .id(valuation.getId())
                .status(valuation.getStatus())
                .createdAt(valuation.getCreatedAt())
                .updatedAt(valuation.getUpdatedAt())
                .customerId(valuation.getCustomerForValuation().getId())
                .projectId(valuation.getProject().getId())
                .build();
    }

    public Valuation toEntity(CreateUpdateValuationDto createUpdateValuationDto) {
        return Valuation.builder()
                .status(createUpdateValuationDto.getStatus())
                .customerForValuation(customerRepository.findById(createUpdateValuationDto.getCustomerId()).get())
                .project(projectRepository.findById(createUpdateValuationDto.getProjectId()).get())
                .build();
    }
}