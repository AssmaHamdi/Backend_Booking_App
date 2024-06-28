package com.hamdi.booking_management.repositories;

import com.hamdi.booking_management.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
