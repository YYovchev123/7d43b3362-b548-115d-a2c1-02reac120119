package com.example.CountryCovid19Microservice.repository;

import com.example.CountryCovid19Microservice.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Optional<Country> findByCountryCode(String countryCode);
}
