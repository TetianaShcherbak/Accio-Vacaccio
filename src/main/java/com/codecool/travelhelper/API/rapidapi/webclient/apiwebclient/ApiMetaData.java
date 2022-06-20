package com.codecool.travelhelper.API.rapidapi.webclient.apiwebclient;

import java.util.HashMap;
import java.util.Map;

public enum ApiMetaData {
    WEATHER ("https://community-open-weather-map.p.rapidapi.com/weather", new HashMap<>(){{
        put("X-RapidAPI-Host", "community-open-weather-map.p.rapidapi.com");
        put("X-RapidAPI-Key", "b186afc8b1msh4bc0a73b4bf87bdp1d1bafjsn15bd5f30345d");
    }}),
    NEWSWORLD("https://newscatcher.p.rapidapi.com/v1/search_free", new HashMap<>(){{
        put("X-RapidAPI-Host", "newscatcher.p.rapidapi.com");
        put("X-RapidAPI-Key", "691ed8695cmsh482afe9729a78bcp12feeejsnecea9fc7b2c1");
    }}),
    LIVING_COSTS ("https://cost-of-living-and-prices.p.rapidapi.com/prices", new HashMap<>(){{
        put("X-RapidAPI-Host", "cost-of-living-and-prices.p.rapidapi.com");
        put("X-RapidAPI-Key", "b186afc8b1msh4bc0a73b4bf87bdp1d1bafjsn15bd5f30345d");
    }}),
    AIRPORT ("https://world-airports-directory.p.rapidapi.com/v1/airports/", new HashMap<>(){{
        put("X-RapidAPI-Host", "world-airports-directory.p.rapidapi.com");
        put("X-RapidAPI-Key", "b186afc8b1msh4bc0a73b4bf87bdp1d1bafjsn15bd5f30345d");
    }}),
    AIRPORT_DETAIL ("https://airport-info.p.rapidapi.com/airport", new HashMap<>(){{
        put("X-RapidAPI-Host", "airport-info.p.rapidapi.com");
        put("X-RapidAPI-Key", "b186afc8b1msh4bc0a73b4bf87bdp1d1bafjsn15bd5f30345d");
    }}),
    BOOKING ("https://best-booking-com-hotel.p.rapidapi.com/booking/best-accommodation", new HashMap<>(){{
        put("X-RapidAPI-Host", "best-booking-com-hotel.p.rapidapi.com");
        put("X-RapidAPI-Key", "a8cfbec453mshc149424874fe8e0p10b6f0jsnfb37d454318e");
    }}),
    CRIME_RATING ("https://ranked-crime-cities.p.rapidapi.com/Kc4Qth/ranked_crime_cities", new HashMap<>(){{
        put("X-RapidAPI-Host", "ranked-crime-cities.p.rapidapi.com");
        put("X-RapidAPI-Key", "b186afc8b1msh4bc0a73b4bf87bdp1d1bafjsn15bd5f30345d");
    }}),
    TRUE_WAY_PLACES("https://trueway-places.p.rapidapi.com/FindPlacesNearby", new HashMap<>(){{
        put("X-RapidAPI-Host", "trueway-places.p.rapidapi.com");
        put("X-RapidAPI-Key", "af26e6ba1cmshe3e8f978bdede11p150bcajsna014b084fe98");
    }}),

    //todo: use it very carefully! Price is 200/month for free + US$0.001 each other
    GOOGLE_AUTOCOMPLETE_PLUS("https://google-maps-autocomplete-plus.p.rapidapi.com/autocomplete",  new HashMap<>(){{
        put("X-RapidAPI-Host", "google-maps-autocomplete-plus.p.rapidapi.com");
        put("X-RapidAPI-Key", "af26e6ba1cmshe3e8f978bdede11p150bcajsna014b084fe98");
    }})
    ;



    private String url;
    private Map<String, String> headersData;

    ApiMetaData(String url, Map<String, String> headersData) {
        this.url = url;
        this.headersData = headersData;
    }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public Map<String, String> getHeadersData() { return headersData; }

    public void setHeadersData(Map<String, String> headersData) { this.headersData = headersData; }
}
