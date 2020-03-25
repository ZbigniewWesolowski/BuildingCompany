package com.craftincode.buildingcompany.service;

import com.craftincode.buildingcompany.controller.dto.employee.CreateUpdateEmployeeDto;
import com.craftincode.buildingcompany.controller.dto.employee.EmployeeDto;
import com.craftincode.buildingcompany.controller.dto.material.CreateMaterialDto;
import com.craftincode.buildingcompany.controller.dto.material.MaterialDto;
import com.craftincode.buildingcompany.controller.dto.material.UpdateMaterialDto;
import com.craftincode.buildingcompany.controller.mapper.MaterialMapper;
import com.craftincode.buildingcompany.model.Employee;
import com.craftincode.buildingcompany.model.Material;
import com.craftincode.buildingcompany.repository.MaterialRepository;
import com.craftincode.buildingcompany.service.exception.EmployeeDataInvalidException;
import com.craftincode.buildingcompany.service.exception.EmployeeNotFoundException;
import com.craftincode.buildingcompany.service.exception.MaterialDataInvalidExeption;
import com.craftincode.buildingcompany.service.exception.MaterialNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialService {
    @Autowired
    MaterialRepository materialRepository;
    @Autowired
    MaterialMapper materialMapper;

    public List<MaterialDto> getAllMaterials() {
        return materialRepository.findAll().stream()
                .map(materialMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public MaterialDto getById(int id) throws MaterialNotFoundException {
        return materialRepository.findById(id)
                .map(materialMapper::fromEntityToDto)
                .orElseThrow(MaterialNotFoundException::new);
    }

    public Material getMaterialById(int id) throws MaterialNotFoundException {
        return materialRepository.findById(id)
                .orElseThrow(MaterialNotFoundException::new);
    }

    public MaterialDto createMaterial(CreateMaterialDto createMaterialDto) throws MaterialDataInvalidExeption {
        if (createMaterialDto.getName() == null) {
            throw new MaterialDataInvalidExeption();
        }
        Material newMaterial = materialMapper.toEntity(createMaterialDto);
        newMaterial.setCreatedAt(OffsetDateTime.now());
        newMaterial.setUpdatedAt(OffsetDateTime.now());
        Material savedMaterial = materialRepository.save(newMaterial);
        return materialMapper.fromEntityToDto(savedMaterial);
    }

    public MaterialDto updateMaterial(int id, UpdateMaterialDto updateMaterialDto) throws MaterialNotFoundException {
        Material materialById = getMaterialById(id);
        if (updateMaterialDto.getPrice() != null) {
            materialById.setPrice(updateMaterialDto.getPrice());
        }
        if (updateMaterialDto.getSupplierName() != null) {
            materialById.setSupplierName(updateMaterialDto.getSupplierName());
        }
        if (updateMaterialDto.getWeight() != null) {
            materialById.setWeight(updateMaterialDto.getWeight());
        }
        materialById.setUpdatedAt(OffsetDateTime.now());
        Material savedMaterial = materialRepository.save(materialById);
        return materialMapper.fromEntityToDto(savedMaterial);
    }

    @Transactional
    public MaterialDto deleteMaterial(int id) throws MaterialNotFoundException {
        Material materialById = getMaterialById(id);
        materialRepository.delete(materialById);
        return materialMapper.fromEntityToDto(materialById);
    }
}
