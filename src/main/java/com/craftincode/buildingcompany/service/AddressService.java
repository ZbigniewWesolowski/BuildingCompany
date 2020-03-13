package com.craftincode.buildingcompany.service;

import com.craftincode.buildingcompany.controller.dto.address.AddressDto;
import com.craftincode.buildingcompany.controller.dto.address.CreateUpdateAddressDto;
import com.craftincode.buildingcompany.controller.mapper.AddressMapper;
import com.craftincode.buildingcompany.model.Address;
import com.craftincode.buildingcompany.repository.AddresseRepository;
import com.craftincode.buildingcompany.service.exception.AddressDataInvalidException;
import com.craftincode.buildingcompany.service.exception.AddressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddresseRepository addresseRepository;
    @Autowired
    private AddressMapper addressMapper;

    public List<AddressDto> getAllAddresses() {
        return addresseRepository.findAll().stream()
                .map(addressMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public AddressDto getById(int id) throws AddressNotFoundException {
        return addresseRepository.findById(id)
                .map(addressMapper::fromEntityToDto)
                .orElseThrow(AddressNotFoundException::new);
    }

    public Address getAddressById(int id) throws AddressNotFoundException {
        return addresseRepository.findById(id)
                .orElseThrow(AddressNotFoundException::new);
    }

    public AddressDto createAddress(CreateUpdateAddressDto createUpdateAddressDto) throws AddressDataInvalidException {
        if (createUpdateAddressDto.getCity() == null) {
            throw new AddressDataInvalidException();
        }
        Address newAddress = addressMapper.toEntity(createUpdateAddressDto);
        newAddress.setCreatedAt(OffsetDateTime.now());
        newAddress.setUpdatedAt(OffsetDateTime.now());
        Address savedAddress = addresseRepository.save(newAddress);
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
        if (createUpdateAddressDto.getCity() !=  null) {
            addressById.setCity(createUpdateAddressDto.getCity());
        }
        addressById.setUpdatedAt(OffsetDateTime.now());
        Address savedAddress = addresseRepository.save(addressById);
        return addressMapper.fromEntityToDto(savedAddress);
    }
    @Transactional
    public AddressDto deleteById(int id) throws AddressNotFoundException {
        Address addressById = getAddressById(id);
        addresseRepository.delete(addressById);
        return addressMapper.fromEntityToDto(addressById);
    }
}
