package com.carledwinti.travel.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookingDto {
    private String destination;
    private LocalDate checkin;
    private LocalDate checkout;
    private Integer adults;
    private Integer children;
}
