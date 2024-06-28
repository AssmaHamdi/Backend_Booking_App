package com.hamdi.booking_management.controllers;

import com.hamdi.booking_management.dto.ServiceDto;
import com.hamdi.booking_management.services.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody ServiceDto serviceDto) {
        return ResponseEntity.ok(service.save(serviceDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ServiceDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{service-id}")
    public ResponseEntity<ServiceDto> findById(@PathVariable("service-id") Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{service-id}")
    public ResponseEntity<Void> delete(@PathVariable("service-id")Integer id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
