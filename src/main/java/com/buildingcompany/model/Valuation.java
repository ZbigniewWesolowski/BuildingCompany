package com.buildingcompany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Valuation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private DocumentStatusEnum status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customerForValuation;
    @OneToOne (mappedBy = "valuation", fetch = FetchType.LAZY,  orphanRemoval = true)
    private Project project;
}
