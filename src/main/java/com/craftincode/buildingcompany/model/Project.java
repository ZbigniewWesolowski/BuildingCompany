package com.craftincode.buildingcompany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private ProjectStatusEnum status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @OneToOne ( fetch = FetchType.LAZY)
    private Valuation valuation;
    @ManyToMany( fetch = FetchType.LAZY)
    private List<Material> materialList;
    @OneToOne (fetch = FetchType.LAZY)
    private SalesDocument salesDocument;
    @OneToOne (fetch = FetchType.LAZY)
    private Address address;

}
