package com.example.CountryCovid19Microservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "countries")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @Column(name = "ID")
    private String ID;
    @Column(name = "Country")
    private String country;
    @Column(name = "CountryCode")
    private String countryCode;
    @Column(name = "Slung")
    private String slung;
    @Column(name = "NewConfirmed")
    private int newConfirmed;
    @Column(name = "TotalConfirmed")
    private int totalConfirmed;
    @Column(name = "NewDeaths")
    private int newDeaths;
    @Column(name = "TotalDeaths")
    private int totalDeaths;
    @Column(name = "NewRecovered")
    private int newRecovered;
    @Column(name = "TotalRecovered")
    private int totalRecovered;
    @Column(name = "Date")
    private Instant date;
    @Column(name = "Premium")
    @Embedded
    private Premium premium;

}