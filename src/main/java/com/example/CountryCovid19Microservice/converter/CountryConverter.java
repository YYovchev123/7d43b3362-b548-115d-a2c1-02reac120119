package com.example.CountryCovid19Microservice.converter;

import com.example.CountryCovid19Microservice.dto.CountryRequestBody;
import com.example.CountryCovid19Microservice.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryConverter {

    public Country convert(CountryRequestBody countryRequestBody) {
        return Country.builder()
                .ID(countryRequestBody.getID())
                .country(countryRequestBody.getCountry())
                .countryCode(countryRequestBody.getCountryCode())
                .slung(countryRequestBody.getSlung())
                .newConfirmed(countryRequestBody.getNewConfirmed())
                .totalConfirmed(countryRequestBody.getTotalConfirmed())
                .newDeaths(countryRequestBody.getNewDeaths())
                .totalDeaths(countryRequestBody.getTotalDeaths())
                .newRecovered(countryRequestBody.getNewRecovered())
                .totalRecovered(countryRequestBody.getTotalRecovered())
                .date(countryRequestBody.getDate())
                .build();
    }
}

