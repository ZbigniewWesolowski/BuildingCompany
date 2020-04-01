package com.buildingcompany.controller.dto.project;

import com.buildingcompany.model.ProjectStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUpdateProjectDto {
    private ProjectStatusEnum status;
    private String projectName;
    private Integer employeeId;
    private Integer valuationId;
    private List<Integer> materialListId;
    private Integer salesDocumentId;
    private Integer addressId;

}