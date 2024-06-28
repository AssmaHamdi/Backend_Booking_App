package com.hamdi.booking_management.services.impl;

import com.hamdi.booking_management.dto.AppointmentDto;
import com.hamdi.booking_management.models.Appointment;
import com.hamdi.booking_management.repositories.AppointmentRepository;
import com.hamdi.booking_management.services.AppointmentService;
import com.hamdi.booking_management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final ObjectsValidator<AppointmentDto> validator;

    @Override
    public Integer save(AppointmentDto dto) {
        validator.validate(dto);
        Appointment appointment = AppointmentDto.toEntity(dto);
        return repository.save(appointment).getId();
    }

    @Override
    public List<AppointmentDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AppointmentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDto findById(Integer id) {
        return repository.findById(id)
                .map(AppointmentDto::fromEntity)
                .orElseThrow( () -> new EntityNotFoundException("appointment not found with this id:" +id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
