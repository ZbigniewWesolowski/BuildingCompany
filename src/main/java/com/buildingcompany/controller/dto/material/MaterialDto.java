package com.buildingcompany.controller.dto.material;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialDto {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer weight;
    private String supplierName;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private List<Integer> projectListForMaterialIds;
}