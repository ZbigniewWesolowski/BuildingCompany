package com.craftincode.buildingcompany.controller.dto.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
    private Integer id;
    private String street;
    private Integer houseNumber;
    private String city;
    private Integer projectId;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;



}
