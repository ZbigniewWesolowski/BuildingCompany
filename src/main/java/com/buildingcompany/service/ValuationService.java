package com.buildingcompany.service;

import com.buildingcompany.controller.dto.address.AddressDto;
import com.buildingcompany.controller.dto.address.CreateUpdateAddressDto;
import com.buildingcompany.controller.dto.valuation.CreateUpdateValuationDto;
import com.buildingcompany.controller.dto.valuation.ValuationDto;
import com.buildingcompany.controller.mapper.ValuationMapper;
import com.buildingcompany.model.Address;
import com.buildingcompany.model.DocumentStatusEnum;
import com.buildingcompany.model.Project;
import com.buildingcompany.model.Valuation;
import com.buildingcompany.repository.ValuationRepository;
import com.buildingcompany.service.exception.AddressDataInvalidException;
import com.buildingcompany.service.exception.AddressNotFoundException;
import com.buildingcompany.service.exception.ValuationDataInvalidException;
import com.buildingcompany.service.exception.ValuationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValuationService {
@Autowired
    ValuationMapper valuationMapper;
@Autowired
    ValuationRepository valuationRepository;

public List<ValuationDto> getAllValuations() {
return valuationRepository.findAll().stream()
        .map(valuationMapper::fromEntitytoDto)
        .collect(Collectors.toList());
}
public ValuationDto getById (int id) throws ValuationNotFoundException {
    return valuationRepository.findById(id)
            .map(valuationMapper::fromEntitytoDto)
            .orElseThrow(ValuationNotFoundException::new);
}

public Valuation getValuadionById (int id) throws ValuationNotFoundException {
return valuationRepository.findById(id)
.orElseThrow(ValuationNotFoundException::new);
}

public ValuationDto createValuation (CreateUpdateValuationDto createUpdateValuationDto) throws ValuationDataInvalidException {
    if (createUpdateValuationDto.getCustomerId() == null || createUpdateValuationDto.getProjectId() == null) {
        throw new ValuationDataInvalidException();
    }
    Valuation newValuation = valuationMapper.toEntity(createUpdateValuationDto);
    newValuation.setCreatedAt(OffsetDateTime.now());
    newValuation.setUpdatedAt(OffsetDateTime.now());
    Valuation savedValuation = valuationRepository.save(newValuation);
    return valuationMapper.fromEntitytoDto(savedValuation);
}

    public ValuationDto updateValuation (int id, CreateUpdateValuationDto createUpdateValuationDto) throws ValuationNotFoundException {
        Valuation valuationById = getValuadionById(id);
        if (createUpdateValuationDto.getStatus() != null) {
            valuationById.setStatus(createUpdateValuationDto.getStatus());
        }
        valuationById.setUpdatedAt(OffsetDateTime.now());
        Valuation savedValudiaton = valuationRepository.save(valuationById);
        return valuationMapper.fromEntitytoDto(savedValudiaton);
    }
    @Transactional
    public ValuationDto deleteById(int id) throws ValuationNotFoundException {
    Valuation valuationById = getValuadionById(id);
    valuationRepository.delete(valuationById);
    return valuationMapper.fromEntitytoDto(valuationById);
    }
}

