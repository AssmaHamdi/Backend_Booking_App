package com.hamdi.booking_management.dto;

import com.hamdi.booking_management.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EmployeeDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String specialty;

    public static EmployeeDto fromEntity(Employee employee) {

        if (employee==null) {
            return null;
        }

        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .password(employee.getPassword())
                .specialty(employee.getSpecialty())
                .build();
    }

    public static Employee toEntity(EmployeeDto employee) {

        if (employee==null) {
            return null;
        }

        return Employee.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .password(employee.getPassword())
                .specialty(employee.getSpecialty())
                .build();
    }
}
