package com.craftincode.buildingcompany.service;

import com.craftincode.buildingcompany.controller.dto.address.AddressDto;
import com.craftincode.buildingcompany.controller.dto.address.CreateUpdateAddressDto;
import com.craftincode.buildingcompany.controller.dto.customer.CreateUpdateCustomerDto;
import com.craftincode.buildingcompany.controller.dto.customer.CustomerDto;
import com.craftincode.buildingcompany.controller.mapper.CustomerMapper;
import com.craftincode.buildingcompany.model.Address;
import com.craftincode.buildingcompany.model.Customer;
import com.craftincode.buildingcompany.repository.CustomerRepository;
import com.craftincode.buildingcompany.service.exception.*;
import com.craftincode.buildingcompany.service.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public CustomerDto getById(int id) throws CustomerNotFoundException {
        return customerRepository.findById(id)
                .map(customerMapper::fromEntityToDto)
                .orElseThrow(CustomerNotFoundException::new);
    }

    public Customer getCustomerById(int id) throws CustomerNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(CustomerNotFoundException::new);
    }

    public CustomerDto createCustomer(CreateUpdateCustomerDto createUpdateCustomerDto) throws CustomerDataInvalidException {
        if (createUpdateCustomerDto.getEmail() == null && createUpdateCustomerDto.getPhone() == null) {
            throw new CustomerDataInvalidException();
        }
        Customer newCustomer = customerMapper.toEntity(createUpdateCustomerDto);
        newCustomer.setCreatedAt(OffsetDateTime.now());
        newCustomer.setUpdatedAt(OffsetDateTime.now());
        Customer savedCustomer = customerRepository.save(newCustomer);
        return customerMapper.fromEntityToDto(savedCustomer);
    }

    public CustomerDto updateCustomer(int id, CreateUpdateCustomerDto createUpdateCustomerDto) throws CustomerNotFoundException {
        Customer customerById = getCustomerById(id);
        if (createUpdateCustomerDto.getName() != null) {
            customerById.setName(createUpdateCustomerDto.getName());
        }
        if (createUpdateCustomerDto.getSurname() != null) {
            customerById.setSurname(createUpdateCustomerDto.getSurname());
        }
        if (createUpdateCustomerDto.getEmail() != null) {
            customerById.setEmail(createUpdateCustomerDto.getEmail());
        }
        if (createUpdateCustomerDto.getPhone() != null) {
            customerById.setPhone(createUpdateCustomerDto.getPhone());
        }
        customerById.setUpdatedAt(OffsetDateTime.now());
        Customer savedCustomer = customerRepository.save(customerById);
        return customerMapper.fromEntityToDto(savedCustomer);
    }

    @Transactional
    public CustomerDto deleteById(int id) throws CustomerNotFoundException {
        Customer customerById = getCustomerById(id);
        customerRepository.delete(customerById);
        return customerMapper.fromEntityToDto(customerById);
    }
}
