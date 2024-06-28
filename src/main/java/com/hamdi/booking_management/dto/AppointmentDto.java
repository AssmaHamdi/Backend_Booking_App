package com.hamdi.booking_management.dto;

import com.hamdi.booking_management.models.Appointment;
import com.hamdi.booking_management.models.Customer;
import com.hamdi.booking_management.models.Employee;
import com.hamdi.booking_management.models.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AppointmentDto {

    private LocalDateTime date;

    private Integer id_customer;

    private Integer id_employee;

    private Integer id_service;


    public static AppointmentDto fromEntity(Appointment appointment) {

        if (appointment == null) {
            return null;
        }

        return AppointmentDto.builder()
                .date(appointment.getDate())
                .id_customer(appointment.getCustomer().getId())
                .id_employee(appointment.getEmployee().getId())
                .id_service(appointment.getService().getId())
                .build();
    }



    public static Appointment toEntity(AppointmentDto appointment) {

        if (appointment == null) {
            return null;
        }

        return Appointment.builder()
                .date(appointment.getDate())
                .customer(
                        Customer.builder()
                                .id(appointment.getId_customer())
                                .build()
                )
                .employee(
                        Employee.builder()
                                .id(appointment.getId_employee())
                                .build()
                )
                .service(
                        Service.builder()
                                .id(appointment.getId_service())
                                .build()
                )

                .build();
    }

}
