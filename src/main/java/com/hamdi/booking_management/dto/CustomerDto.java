package com.hamdi.booking_management.dto;

import com.hamdi.booking_management.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomerDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    public static CustomerDto fromEntity(Customer customer) {

        if (customer == null)
        {return null;}

        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .phone(customer.getPhone())
                .build();
    }

    public static Customer toEntity(CustomerDto customer) {

        if (customer == null)
        {return null;}

        return Customer.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .phone(customer.getPhone())
                .build();
    }
}
