package com.buildingcompany.service;

import com.buildingcompany.controller.dto.project.CreateUpdateProjectDto;
import com.buildingcompany.controller.dto.project.ProjectDto;
import com.buildingcompany.controller.mapper.ProjectMapper;
import com.buildingcompany.model.Project;
import com.buildingcompany.repository.ProjectRepository;
import com.buildingcompany.service.exception.ProjectDataInvalidException;
import com.buildingcompany.service.exception.ProjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ProjectRepository projectRepository;
    public List<ProjectDto> getAll () {
        return projectRepository.findAll().stream()
                .map(projectMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }
    public ProjectDto getById (int id) throws ProjectNotFoundException {
        return projectRepository.findById(id)
                .map(projectMapper::fromEntityToDto)
                .orElseThrow(ProjectNotFoundException::new);
    }

    public Project getProjectById (int id) throws ProjectNotFoundException {
        return projectRepository.findById(id)
                .orElseThrow(ProjectNotFoundException::new);
    }

    public ProjectDto createProject (CreateUpdateProjectDto createUpdateProjectDto) throws ProjectDataInvalidException {
        if (createUpdateProjectDto.getProjectName() == null) {
            throw new ProjectDataInvalidException();
        }
        Project newProject = projectMapper.toEntity(createUpdateProjectDto);
        newProject.setCreatedAt(OffsetDateTime.now());
        newProject.setUpdatedAt(OffsetDateTime.now());
        Project savedProject = projectRepository.save(newProject);
        return projectMapper.fromEntityToDto(savedProject);
    }

//    public ProjectDto updateProject (int id, CreateUpdateProjectDto createUpdateProjectDto) {
//        Project projectById = getProjectById(id);
//        if (updateProject(.get))
//    Material materialById = getMaterialById(id);
//        if (updateMaterialDto.getPrice() != null) {
//        materialById.setPrice(updateMaterialDto.getPrice());
//    }
//        if (updateMaterialDto.getSupplierName() != null) {
//        materialById.setSupplierName(updateMaterialDto.getSupplierName());
//    }
//        if (updateMaterialDto.getWeight() != null) {
//        materialById.setWeight(updateMaterialDto.getWeight());
//    }
//        materialById.setUpdatedAt(OffsetDateTime.now());
//    Material savedMaterial = materialRepository.save(materialById);
//        return materialMapper.fromEntityToDto(savedMaterial);
//}
//
//    @Transactional
//    public MaterialDto deleteMaterial(int id) throws MaterialNotFoundException {
//        Material materialById = getMaterialById(id);
//        materialRepository.delete(materialById);
//        return materialMapper.fromEntityToDto(materialById);
//    }
}

