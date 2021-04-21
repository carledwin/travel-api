package com.carledwinti.travel.api.controller;

import com.carledwinti.travel.api.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.carledwinti.travel.api.constants.Constants.MESSAGE_SUCCESSFULLY;

@RestController
@RequestMapping("/travel-with-service")
public class TravelWithServiceController {

    @Autowired
    private TravelService travelService;

    /*
    It works as @Autowired
    private TravelService travelService;
    public TravelWithServiceController(TravelService travelService){
        this.travelService = travelService;
    }
    */

    @GetMapping("/status/from-service")
    public String statusFromService(){
        return travelService.status();
    }
}
