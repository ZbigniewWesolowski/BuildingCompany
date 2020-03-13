package com.craftincode.buildingcompany.repository;

import com.craftincode.buildingcompany.model.SalesDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDocumentRepository extends JpaRepository<SalesDocument, Integer> {
}
