package com.codecool.travelhelper.API.rapidapi.controller.apicontroller;

import com.codecool.travelhelper.API.rapidapi.model.apimodel.BookingApiModel;
import com.codecool.travelhelper.API.rapidapi.service.apiservice.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BookingApiController {

    @Autowired
    BookingService bookingService;

//    @GetMapping("/booking/{cityName}/{countryName}")
//    public BookingApiModel getBooking(@PathVariable String cityName, @PathVariable String countryName){
//        return bookingService.getBooking(cityName, countryName);
//    }
}
