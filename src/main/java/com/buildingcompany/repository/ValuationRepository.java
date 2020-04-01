package com.buildingcompany.repository;

import com.buildingcompany.model.Valuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValuationRepository extends JpaRepository<Valuation, Integer> {
}
