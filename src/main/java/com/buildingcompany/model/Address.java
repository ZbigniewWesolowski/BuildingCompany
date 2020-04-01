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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String street;
    private Integer houseNumber;
    private String city;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Project project;

}
