package com.craftincode.buildingcompany.repository;

import com.craftincode.buildingcompany.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.ws.RespectBinding;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
