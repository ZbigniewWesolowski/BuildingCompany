package com.buildingcompany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer weight;
    private String supplierName;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Project> projectListForMaterial;
}
