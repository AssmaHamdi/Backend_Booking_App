package com.hamdi.booking_management.repositories;

import com.hamdi.booking_management.dto.CustomerDto;
import com.hamdi.booking_management.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllById(Integer id);
}
