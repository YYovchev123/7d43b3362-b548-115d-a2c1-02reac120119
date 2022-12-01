package com.example.CountryCovid19Microservice.dto;

import com.example.CountryCovid19Microservice.model.Premium;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CountryRequestBody {

    @JsonProperty("ID")
    private String ID;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("Slung")
    private String slung;
    @JsonProperty("NewConfirmed")
    private int newConfirmed;
    @JsonProperty("TotalConfirmed")
    private int totalConfirmed;
    @JsonProperty("NewDeaths")
    private int newDeaths;
    @JsonProperty("TotalDeaths")
    private int totalDeaths;
    @JsonProperty("NewRecovered")
    private int newRecovered;
    @JsonProperty("TotalRecovered")
    private int totalRecovered;
    @JsonProperty("Date")
    private Instant date;
    @JsonProperty("Premium")
    private Premium premium;
}

