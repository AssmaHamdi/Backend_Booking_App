package com.hamdi.booking_management.controllers;

import com.hamdi.booking_management.dto.AppointmentDto;
import com.hamdi.booking_management.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AppointmentDto appointmentDto) {
      return  ResponseEntity.ok(service.save(appointmentDto));
    }
    @GetMapping("/")
    public ResponseEntity<List<AppointmentDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id-appointment}")
    public ResponseEntity<AppointmentDto> findById(@PathVariable("id-appointment") Integer id ) {
        return ResponseEntity.ok(service.findById(id));
    }
    @DeleteMapping("/{id-appointment}")
    public ResponseEntity<Void> delete(@PathVariable("id-appointment")Integer id){
        service.delete(id);
        return ResponseEntity.accepted().build();
    }


}
