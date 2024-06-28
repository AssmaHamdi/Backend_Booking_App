package com.hamdi.booking_management.services.impl;

import com.hamdi.booking_management.dto.CustomerDto;
import com.hamdi.booking_management.models.Customer;
import com.hamdi.booking_management.repositories.CustomerRepository;
import com.hamdi.booking_management.services.CustomerService;
import com.hamdi.booking_management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final ObjectsValidator<CustomerDto> validator;


    @Override
    public List<CustomerDto> findAllById(Integer id) {
        return repository.findAllById(id)
                .stream().map(CustomerDto::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public Integer save(CustomerDto dto) {
        validator.validate(dto);
        Customer customer = CustomerDto.toEntity(dto);
        return repository.save(customer).getId();
    }

    @Override
    public List<CustomerDto> findAll() {
        return repository.findAll().stream()
                .map(CustomerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto findById(Integer id) {
        return repository.findById(id)
                .map(CustomerDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("cistomer not found widh id:" +id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);

    }
}
