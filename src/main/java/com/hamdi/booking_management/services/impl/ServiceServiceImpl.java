package com.hamdi.booking_management.services.impl;

import com.hamdi.booking_management.dto.ServiceDto;
import com.hamdi.booking_management.repositories.ServiceRepository;
import com.hamdi.booking_management.services.ServiceService;
import com.hamdi.booking_management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository repository;
    private final ObjectsValidator<ServiceDto> validator;


    @Override
    public Integer save(ServiceDto dto) {
        validator.validate(dto);
        com.hamdi.booking_management.models.Service service = ServiceDto.toEntity(dto);
        return repository.save(service).getId();
    }

    @Override
    public List<ServiceDto> findAll() {
        return repository.findAll().stream()
                .map(ServiceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceDto findById(Integer id) {
        return repository.findById(id)
                .map(ServiceDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("service not found with id:"+id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);

    }
}
