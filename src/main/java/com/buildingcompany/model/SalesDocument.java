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
public class SalesDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private DocumentStatusEnum status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    @OneToOne (mappedBy = "salesDocument", fetch = FetchType.LAZY)
    private Project project;
}
