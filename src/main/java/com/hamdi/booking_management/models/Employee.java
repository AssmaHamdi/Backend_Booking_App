package com.hamdi.booking_management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name="Employee")
public class Employee extends AbstractEntity{

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String specialty;

    @OneToMany(mappedBy = "employee")
    private List<Appointment> appointments;
}
