package com.hamdi.booking_management.controllers;

import com.hamdi.booking_management.dto.CustomerDto;
import com.hamdi.booking_management.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(service.save(customerDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerDto> findById( @PathVariable("customer-id") Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> delete( @PathVariable("customer-id")Integer id) {
        service.delete(id);
       return ResponseEntity.accepted().build();
    }
}
