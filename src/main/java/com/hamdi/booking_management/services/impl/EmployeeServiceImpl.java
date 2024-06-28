package com.hamdi.booking_management.services.impl;

import com.hamdi.booking_management.dto.EmployeeDto;
import com.hamdi.booking_management.models.Employee;
import com.hamdi.booking_management.repositories.EmployeeRepository;
import com.hamdi.booking_management.services.EmployeeService;
import com.hamdi.booking_management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ObjectsValidator<EmployeeDto> validator;


    @Override
    public Integer save(EmployeeDto dto) {
        validator.validate(dto);
        Employee employee = EmployeeDto.toEntity(dto);
        return repository.save(employee).getId();
    }

    @Override
    public List<EmployeeDto> findAll() {
        return repository.findAll().stream()
                .map(EmployeeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto findById(Integer id) {
        return repository.findById(id)
                .map(EmployeeDto::fromEntity)
                .orElseThrow( () -> new EntityNotFoundException("employee not found with this id:"+ id));
    }

    @Override
    public void delete(Integer id) {

        repository.deleteById(id);

    }
}
