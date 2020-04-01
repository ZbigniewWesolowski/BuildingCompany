package com.buildingcompany.controller.mapper;

import com.buildingcompany.controller.dto.address.AddressDto;
import com.buildingcompany.controller.dto.address.CreateUpdateAddressDto;
import com.buildingcompany.model.Address;

import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDto fromEntityToDto(Address address) {
        Integer projectId = address.getProject() != null ? address.getProject().getId() : null;
        return AddressDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .city(address.getCity())
                .projectId(projectId)
                .createdAt(address.getCreatedAt())
                .updatedAt(address.getUpdatedAt())
                .build();
    }

    public Address toEntity(CreateUpdateAddressDto createUpdateAddressDto) {
        return Address.builder()
                .street(createUpdateAddressDto.getStreet())
                .houseNumber(createUpdateAddressDto.getHouseNumber())
                .city(createUpdateAddressDto.getCity())
                .build();
    }
}



