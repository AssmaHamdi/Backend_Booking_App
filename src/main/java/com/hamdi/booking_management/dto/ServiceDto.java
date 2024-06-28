package com.hamdi.booking_management.dto;

import com.hamdi.booking_management.models.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ServiceDto {

    private  Integer id;

    private String name;

    private String description;

    private Integer duration;

    private BigDecimal price;


    public static ServiceDto fromEntity(Service service) {

        if (service==null) {
            return null;
        }

        return ServiceDto.builder()
                .id(service.getId())
                .name(service.getName())
                .description(service.getDescription())
                .duration(service.getDuration())
                .price((service.getPrice()))
                .build();
    }

    public static Service toEntity(ServiceDto service) {

        if (service==null) {
            return null;
        }

        return Service.builder()
                .id(service.getId())
                .name(service.getName())
                .description(service.getDescription())
                .duration(service.getDuration())
                .price((service.getPrice()))
                .build();
    }


}
