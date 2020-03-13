package com.craftincode.buildingcompany.controller.mapper;

import com.craftincode.buildingcompany.controller.dto.employee.CreateUpdateEmployeeDto;
import com.craftincode.buildingcompany.controller.dto.employee.EmployeeDto;
import com.craftincode.buildingcompany.model.Employee;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {


    public EmployeeDto fromEntityToDto(Employee employee) {
        List<Integer> projectsListForEmployeeIds = employee.getProjectListForEmployee().stream()
                .map(project -> project.getId())
                .collect(Collectors.toList());
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .phone(employee.getPhone())
                .role(employee.getRole())
                .createdAt(employee.getCreatedAt())
                .updatedAt(employee.getUpdatedAt())
                .projectsListForEmployeeIds(projectsListForEmployeeIds)
                .build();
    }

    public Employee toEntity(CreateUpdateEmployeeDto createUpdateEmployeeDto) {
        return Employee.builder()
                .name(createUpdateEmployeeDto.getName())
                .surname(createUpdateEmployeeDto.getSurname())
                .role(createUpdateEmployeeDto.getRole())
                .phone(createUpdateEmployeeDto.getPhone())
                .build();
    }
}

