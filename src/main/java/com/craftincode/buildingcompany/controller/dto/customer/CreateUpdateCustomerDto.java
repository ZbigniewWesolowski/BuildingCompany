package com.craftincode.buildingcompany.controller.dto.customer;
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
public class CreateUpdateCustomerDto {
    private String name;
    private String surname;
    private String email;
    private String phone;
}

