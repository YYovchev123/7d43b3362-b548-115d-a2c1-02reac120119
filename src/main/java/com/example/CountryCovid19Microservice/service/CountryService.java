package com.example.CountryCovid19Microservice.service;

import com.example.CountryCovid19Microservice.model.Country;

import java.util.List;

public interface CountryService {

    Country findByCountryCode(String countryCode);
    String save(List<Country> countries);
}
