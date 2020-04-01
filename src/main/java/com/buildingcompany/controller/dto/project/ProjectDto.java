package com.buildingcompany.controller.dto.project;

import com.buildingcompany.model.ProjectStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {
    private Integer id;
    private String projectName;
    private ProjectStatusEnum status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Integer employeeId;
    private Integer valuationId;
    private List<Integer> materialListId;
    private Integer salesDocumentId;
    private Integer addressId;

}