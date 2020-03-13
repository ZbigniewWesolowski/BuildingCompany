package com.craftincode.buildingcompany.controller.dto.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUpdateAddressDto {
    private String street;
    private Integer houseNumber;
    private String city;
}
