package com.buildingcompany.service;

import com.buildingcompany.controller.dto.employee.CreateUpdateEmployeeDto;
import com.buildingcompany.controller.dto.employee.EmployeeDto;
import com.buildingcompany.controller.mapper.EmployeeMapper;
import com.buildingcompany.repository.EmployeeRepository;
import com.buildingcompany.model.Employee;
import com.buildingcompany.service.exception.EmployeeDataInvalidException;
import com.buildingcompany.service.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public EmployeeDto getById(int id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id)
                .map(employeeMapper::fromEntityToDto)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public EmployeeDto createEmployee(CreateUpdateEmployeeDto createUpdateEmployeeDto) throws EmployeeDataInvalidException {
        if (createUpdateEmployeeDto.getName() == null && createUpdateEmployeeDto.getSurname() == null) {
            throw new EmployeeDataInvalidException();
        }
        Employee newEmployee = employeeMapper.toEntity(createUpdateEmployeeDto);
        newEmployee.setCreatedAt(OffsetDateTime.now());
        newEmployee.setUpdatedAt(OffsetDateTime.now());
        Employee savedEmployee = employeeRepository.save(newEmployee);
        return employeeMapper.fromEntityToDto(savedEmployee);
    }

    public EmployeeDto updateEmployee(int id, CreateUpdateEmployeeDto createUpdateEmployeeDto) throws EmployeeNotFoundException {
        Employee employeeById = getEmployeeById(id);
        if (createUpdateEmployeeDto.getName() != null) {
            employeeById.setName(createUpdateEmployeeDto.getName());
        }
        if (createUpdateEmployeeDto.getSurname() != null) {
            employeeById.setSurname(createUpdateEmployeeDto.getSurname());
        }
        if (createUpdateEmployeeDto.getPhone() != null) {
            employeeById.setPhone(createUpdateEmployeeDto.getPhone());
        }
        if (createUpdateEmployeeDto.getRole() != null) {
            employeeById.setRole(createUpdateEmployeeDto.getRole());
        }
        employeeById.setUpdatedAt(OffsetDateTime.now());
        Employee savedEmployee = employeeRepository.save(employeeById);
        return employeeMapper.fromEntityToDto(savedEmployee);
    }

    @Transactional
    public EmployeeDto deleteEmployee(int id) throws EmployeeNotFoundException {
        Employee employeeById = getEmployeeById(id);
        employeeRepository.delete(employeeById);
        return employeeMapper.fromEntityToDto(employeeById);
    }
}
