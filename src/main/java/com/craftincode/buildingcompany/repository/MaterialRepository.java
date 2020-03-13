package com.craftincode.buildingcompany.repository;

import com.craftincode.buildingcompany.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
