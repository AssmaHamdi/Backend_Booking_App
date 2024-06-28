package com.hamdi.booking_management.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name="Service")
public class Service extends AbstractEntity{

    private String name;

    private String description;

    private Integer duration;

    private BigDecimal price;

    @OneToMany(mappedBy = "service")
    private List<Appointment> appointments;
}
