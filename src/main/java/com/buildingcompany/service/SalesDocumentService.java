package com.buildingcompany.service;

import com.buildingcompany.controller.dto.salesDocument.CreateSalesDocumentDto;
import com.buildingcompany.controller.dto.salesDocument.SalesDocumentDto;
import com.buildingcompany.controller.dto.salesDocument.UpdateSalesDocumentDto;
import com.buildingcompany.controller.mapper.SalesDocumentMapper;
import com.buildingcompany.repository.SalesDocumentRepository;
import com.buildingcompany.service.exception.SalesDocuentNotFoundException;
import com.buildingcompany.service.exception.SalesDocumentDataInfalidException;
import com.buildingcompany.model.SalesDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesDocumentService {
    @Autowired
    SalesDocumentRepository salesDocumentRepository;
    @Autowired
    SalesDocumentMapper salesDocumentMapper;

    public List<SalesDocumentDto> getAllSalesDocuments() {
        return salesDocumentRepository.findAll().stream()
                .map(salesDocumentMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public SalesDocumentDto getById(int id) throws SalesDocuentNotFoundException {
        return salesDocumentRepository.findById(id)
                .map(salesDocumentMapper::fromEntityToDto)
                .orElseThrow(SalesDocuentNotFoundException::new);
    }

    public SalesDocument getSalesDocumentById(int id) throws SalesDocuentNotFoundException {
        return salesDocumentRepository.findById(id)
                .orElseThrow(SalesDocuentNotFoundException::new);
    }

    public SalesDocumentDto createSalesDocument(CreateSalesDocumentDto createSalesDocumentDto) throws SalesDocumentDataInfalidException {
        if (createSalesDocumentDto.getProjectId() == null) {
            throw new SalesDocumentDataInfalidException();
        }
        SalesDocument newSalesDocument = salesDocumentMapper.toEntity(createSalesDocumentDto);
        newSalesDocument.setCreatedAt(OffsetDateTime.now());
        newSalesDocument.setUpdatedAt(OffsetDateTime.now());
        SalesDocument savedSalesDocument = salesDocumentRepository.save(newSalesDocument);
        return salesDocumentMapper.fromEntityToDto(savedSalesDocument);
    }

    public SalesDocumentDto updateSalesDocument(int id, UpdateSalesDocumentDto updateSalesDocumentDto) throws SalesDocuentNotFoundException {
        SalesDocument salesDocumentById = getSalesDocumentById(id);
        if (updateSalesDocumentDto.getStatus() != null) {
            salesDocumentById.setStatus(updateSalesDocumentDto.getStatus());
        }
        salesDocumentById.setUpdatedAt(OffsetDateTime.now());
        SalesDocument savedSalesDocument = salesDocumentRepository.save(salesDocumentById);
        return salesDocumentMapper.fromEntityToDto(savedSalesDocument);
    }

    @Transactional
    public SalesDocumentDto deleteSalesDocument(int id) throws SalesDocuentNotFoundException {
        SalesDocument salesDocument = getSalesDocumentById(id);
        salesDocumentRepository.delete(salesDocument);
        return salesDocumentMapper.fromEntityToDto(salesDocument);
    }
}
