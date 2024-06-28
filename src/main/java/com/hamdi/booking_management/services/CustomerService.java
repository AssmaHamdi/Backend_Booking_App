package com.hamdi.booking_management.services;

import com.hamdi.booking_management.dto.CustomerDto;

import java.util.List;

public interface CustomerService extends AbstractService<CustomerDto>{

   List<CustomerDto> findAllById(Integer id);
}
