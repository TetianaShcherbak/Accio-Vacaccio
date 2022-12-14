package com.codecool.travelhelper.aws.database.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class WorldNewsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;
    private String countryName;
    private String newsTitle;
    private String newsLink;


    public WorldNewsTable(String cityName, String countryName, String newsTitle, String newsLink) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.newsTitle = newsTitle;
        this.newsLink = newsLink;
    }
}
