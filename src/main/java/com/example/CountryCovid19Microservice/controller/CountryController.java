package com.example.CountryCovid19Microservice.controller;

import com.example.CountryCovid19Microservice.converter.CountryConverter;
import com.example.CountryCovid19Microservice.dto.CountryRequestBody;
import com.example.CountryCovid19Microservice.model.Country;
import com.example.CountryCovid19Microservice.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/country")
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;
    private CountryConverter countryConverter;

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveAllCountries(@RequestBody List<CountryRequestBody> countries) {
        countryService.save(countries.stream().map(countryConverter::convert).collect(Collectors.toList()));
        return ResponseEntity.ok("All countries saved!");
    }

    @GetMapping(value = "/{countryCode}")
    public ResponseEntity<Country> findCountryByCode(@PathVariable String countryCode) {
        return ResponseEntity.ok(countryService.findByCountryCode(countryCode));
    }
}
