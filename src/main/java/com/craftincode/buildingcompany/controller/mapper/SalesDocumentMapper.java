package com.craftincode.buildingcompany.controller.mapper;

import com.craftincode.buildingcompany.controller.dto.salesDocument.CreateSalesDocumentDto;
import com.craftincode.buildingcompany.controller.dto.salesDocument.SalesDocumentDto;
import com.craftincode.buildingcompany.controller.dto.salesDocument.UpdateSalesDocumentDto;
import com.craftincode.buildingcompany.model.DocumentStatusEnum;
import com.craftincode.buildingcompany.model.SalesDocument;
import com.craftincode.buildingcompany.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

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
