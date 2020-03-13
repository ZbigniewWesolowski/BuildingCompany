package com.craftincode.buildingcompany.controller.dto.employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUpdateEmployeeDto {
    private String name;
    private String surname;
    private String phone;
    private String role;
}