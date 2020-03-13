package com.craftincode.buildingcompany.repository;


import com.craftincode.buildingcompany.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddresseRepository extends JpaRepository<Address, Integer> {
}