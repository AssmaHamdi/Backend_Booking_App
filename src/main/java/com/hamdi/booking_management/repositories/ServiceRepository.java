package com.hamdi.booking_management.repositories;

import com.hamdi.booking_management.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
