package com.buildingcompany.controller.dto.employee;
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
public class EmployeeDto {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String role;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private List<Integer> projectsListForEmployeeIds;
}
