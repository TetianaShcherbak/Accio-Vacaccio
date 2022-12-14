package com.codecool.travelhelper.API.rapidapi.controllers;

import com.codecool.travelhelper.API.rapidapi.models.WorldNewsApiModel;
import com.codecool.travelhelper.API.rapidapi.services.WorldNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class WorldNewsController {

    @Autowired
    private final WorldNewsService worldNewsService;


    @GetMapping("/news/{cityName}/{countryName}")
    public List<WorldNewsApiModel> getNews(@PathVariable String cityName, @PathVariable String countryName){
        return worldNewsService.getNews(cityName, countryName);
    }
}
