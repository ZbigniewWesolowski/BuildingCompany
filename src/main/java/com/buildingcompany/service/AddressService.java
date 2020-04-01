package com.buildingcompany.service;

import com.buildingcompany.controller.dto.address.AddressDto;
import com.buildingcompany.controller.dto.address.CreateUpdateAddressDto;
import com.buildingcompany.controller.mapper.AddressMapper;
import com.buildingcompany.model.Address;
import com.buildingcompany.repository.AddressRepository;
import com.buildingcompany.service.exception.AddressDataInvalidException;
import com.buildingcompany.service.exception.AddressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressMapper addressMapper;

    public List<AddressDto> getAllAddresses() {
        return addressRepository.findAll().stream()
                .map(addressMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public AddressDto getById(int id) throws AddressNotFoundException {
        return addressRepository.findById(id)
                .map(addressMapper::fromEntityToDto)
                .orElseThrow(AddressNotFoundException::new);
    }

    public Address getAddressById(int id) throws AddressNotFoundException {
        return addressRepository.findById(id)
                .orElseThrow(AddressNotFoundException::new);
    }

    public AddressDto createAddress(CreateUpdateAddressDto createUpdateAddressDto) throws AddressDataInvalidException {
        if (createUpdateAddressDto.getCity() == null) {
            throw new AddressDataInvalidException();
        }
        Address newAddress = addressMapper.toEntity(createUpdateAddressDto);
        newAddress.setCreatedAt(OffsetDateTime.now());
        newAddress.setUpdatedAt(OffsetDateTime.now());
        Address savedAddress = addressRepository.save(newAddress);
        return addressMapper.fromEntityToDto(savedAddress);
    }

    public AddressDto updateAddress(int id, CreateUpdateAddressDto createUpdateAddressDto) throws AddressNotFoundException {
        Address addressById = getAddressById(id);
        if (createUpdateAddressDto.getStreet() != null) {
            addressById.setStreet(createUpdateAddressDto.getStreet());
        }
        if (createUpdateAddressDto.getHouseNumber() != null) {
            addressById.setHouseNumber(createUpdateAddressDto.getHouseNumber());
        }
        if (createUpdateAddressDto.getCity() != null) {
            addressById.setCity(createUpdateAddressDto.getCity());
        }
        addressById.setUpdatedAt(OffsetDateTime.now());
        Address savedAddress = addressRepository.save(addressById);
        return addressMapper.fromEntityToDto(savedAddress);
    }

    @Transactional
    public AddressDto deleteById(int id) throws AddressNotFoundException {
        Address addressById = getAddressById(id);
        addressRepository.delete(addressById);
        return addressMapper.fromEntityToDto(addressById);
    }
}
