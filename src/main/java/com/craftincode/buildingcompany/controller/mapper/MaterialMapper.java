package com.craftincode.buildingcompany.controller.mapper;

import com.craftincode.buildingcompany.controller.dto.material.CreateMaterialDto;
import com.craftincode.buildingcompany.controller.dto.material.MaterialDto;
import com.craftincode.buildingcompany.controller.dto.material.UpdateMaterialDto;
import com.craftincode.buildingcompany.model.Material;
import com.craftincode.buildingcompany.model.Project;
import org.springframework.stereotype.Component;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MaterialMapper {

        public MaterialDto fromEntityToDto(Material material) {
            List<Integer> projectListForMaterialIds = material.getProjectListForMaterial().stream()
                    .map(project -> project.getId())
                    .collect(Collectors.toList());
            return MaterialDto.builder()
            .id(material.getId())
                    .name(material.getName())
                    .price(material.getPrice())
                    .weight(material.getWeight())
                    .supplierName(material.getSupplierName())
                    .projectListForMaterialIds(projectListForMaterialIds)
                    .build();
        }
        public Material toEntity (CreateMaterialDto createMaterialDto) {
            return Material.builder()
                    .name(createMaterialDto.getName())
                    .price(createMaterialDto.getPrice())
                    .weight(createMaterialDto.getWeight())
                    .supplierName(createMaterialDto.getSupplierName())
                    .build();
        }
        public Material toEntity (UpdateMaterialDto updateMaterialDto) {
            return Material.builder()
                    .price(updateMaterialDto.getPrice())
                    .weight(updateMaterialDto.getWeight())
                    .supplierName(updateMaterialDto.getSupplierName())
                    .build();
        }
}