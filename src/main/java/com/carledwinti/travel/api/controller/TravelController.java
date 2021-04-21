package com.carledwinti.travel.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.carledwinti.travel.api.constants.Constants.MESSAGE_SUCCESSFULLY;

@RestController
@RequestMapping("/travel")
public class TravelController {

    @GetMapping("/status")
    public String status(){
        return MESSAGE_SUCCESSFULLY;
    }
}
