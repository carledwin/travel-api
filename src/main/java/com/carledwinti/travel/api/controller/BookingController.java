package com.carledwinti.travel.api.controller;

import com.carledwinti.travel.api.dto.BookingDto;
import com.carledwinti.travel.api.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<BookingDto> all(){
        return bookingService.all();
    }
}
