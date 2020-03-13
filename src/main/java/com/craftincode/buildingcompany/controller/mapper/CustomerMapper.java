package com.craftincode.buildingcompany.controller.mapper;
import com.craftincode.buildingcompany.controller.dto.customer.CreateUpdateCustomerDto;
import com.craftincode.buildingcompany.controller.dto.customer.CustomerDto;
import com.craftincode.buildingcompany.model.Customer;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component

public class CustomerMapper {


    public CustomerDto fromEntityToDto(Customer customer) {
        List<Integer> valuationsIds = customer.getValuationListForCustomer().stream()
                .map(valuation -> valuation.getId())
                .collect(Collectors.toList());
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .createdAt(customer.getCreatedAt())
                .updatedAt(customer.getUpdatedAt())
                .valuationsIds(valuationsIds)
                .build();
    }

    public Customer toEntity(CreateUpdateCustomerDto createUpdateCustomerDto) {
        return Customer.builder()
                .name(createUpdateCustomerDto.getName())
                .surname(createUpdateCustomerDto.getSurname())
                .email(createUpdateCustomerDto.getEmail())
                .phone(createUpdateCustomerDto.getPhone())
                .build();
    }
}


