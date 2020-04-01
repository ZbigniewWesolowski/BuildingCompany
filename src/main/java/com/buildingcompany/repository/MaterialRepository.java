package com.buildingcompany.repository;

import com.buildingcompany.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
