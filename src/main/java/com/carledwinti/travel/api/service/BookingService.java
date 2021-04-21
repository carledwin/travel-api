package com.carledwinti.travel.api.service;

import com.carledwinti.travel.api.dto.BookingDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookingService {
    public List<BookingDto> all() {
        return Arrays
                .asList(BookingDto.builder().destination("Ubatuba").build(),
                        BookingDto.builder().destination("Caraguatatuba").build(),
                        BookingDto.builder().destination("Sao Sebastiao").build());
    }
}
