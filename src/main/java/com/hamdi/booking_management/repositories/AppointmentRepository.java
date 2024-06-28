package com.hamdi.booking_management.repositories;

import com.hamdi.booking_management.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
