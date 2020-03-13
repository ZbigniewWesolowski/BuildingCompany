package com.craftincode.buildingcompany.controller.dto.project;

import com.craftincode.buildingcompany.model.ProjectStatusEnum;
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
public class CreateUpdateProjectDto {
    private ProjectStatusEnum status;
    private Integer employeeId;
    private Integer valuationId;
    private List<Integer> materialListId;
    private Integer salesDocumentId;
    private Integer addressId;

}