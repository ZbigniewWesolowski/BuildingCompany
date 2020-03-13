package com.craftincode.buildingcompany.repository;

import com.craftincode.buildingcompany.model.Valuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValuationRepository extends JpaRepository<Valuation, Integer> {
}
