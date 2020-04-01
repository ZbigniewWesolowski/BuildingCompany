package com.buildingcompany.controller.mapper;

import com.buildingcompany.controller.dto.salesDocument.CreateSalesDocumentDto;
import com.buildingcompany.controller.dto.salesDocument.SalesDocumentDto;
import com.buildingcompany.controller.dto.salesDocument.UpdateSalesDocumentDto;
import com.buildingcompany.model.SalesDocument;
import com.buildingcompany.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesDocumentMapper {
    @Autowired
    private ProjectRepository projectRepository;

    public SalesDocumentDto fromEntityToDto(SalesDocument salesDocument) {
        return SalesDocumentDto.builder()
                .id(salesDocument.getId())
                .status(salesDocument.getStatus())
                .createdAt(salesDocument.getCreatedAt())
                .updatedAt(salesDocument.getUpdatedAt())
                .projectId(salesDocument.getProject().getId())
                .build();
    }

    public SalesDocument toEntity (CreateSalesDocumentDto createSalesDocumentDto) {
        return SalesDocument.builder()
        .status(createSalesDocumentDto.getStatus())
        .project(projectRepository.findById(createSalesDocumentDto.getProjectId()).get())
                .build();
        }
        public SalesDocument toEntity (UpdateSalesDocumentDto updateSalesDocumentDto) {
        return SalesDocument.builder()
                .status(updateSalesDocumentDto.getStatus())
                .build();
        }

}
