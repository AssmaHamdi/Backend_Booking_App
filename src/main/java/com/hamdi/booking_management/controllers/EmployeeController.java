package com.hamdi.booking_management.controllers;

import com.hamdi.booking_management.dto.EmployeeDto;
import com.hamdi.booking_management.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(service.save(employeeDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{employee-id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable("employee-id") Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{employee-id}")
    public ResponseEntity<Void> delete(@PathVariable("employee-id")Integer id){
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
