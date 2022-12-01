package com.example.CountryCovid19Microservice.service;

import com.example.CountryCovid19Microservice.exception.RecordNotFoundException;
import com.example.CountryCovid19Microservice.model.Country;
import com.example.CountryCovid19Microservice.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService{

    private CountryRepository countryRepository;

    @Override
    public Country findByCountryCode(String countryCode) {
        return countryRepository.findByCountryCode(countryCode)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Country with country code: %s is not found!", countryCode)));
    }

    @Override
    public String save(List<Country> countries) {
        countryRepository.saveAll(countries);
        return "All countries are saved!";
    }
}
