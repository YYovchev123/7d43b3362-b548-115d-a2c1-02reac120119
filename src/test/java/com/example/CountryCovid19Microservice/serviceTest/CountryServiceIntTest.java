package com.example.CountryCovid19Microservice.serviceTest;

import com.example.CountryCovid19Microservice.exception.RecordNotFoundException;
import com.example.CountryCovid19Microservice.model.Country;
import com.example.CountryCovid19Microservice.repository.CountryRepository;
import com.example.CountryCovid19Microservice.service.CountryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CountryServiceIntTest {

    private CountryServiceImpl countryService;
    @Mock
    private CountryRepository countryRepository;

    @BeforeEach
    public void setUp() {
        countryService = new CountryServiceImpl(countryRepository);
    }

    @Test
    public void verifyFindCountryByCountryCode() {
        String countryCode = "BG";
        Country country = Country.builder()
                .countryCode(countryCode)
                .build();
        when(countryRepository.findByCountryCode(countryCode))
                .thenReturn(Optional.of(country));
        countryService.findByCountryCode(countryCode);
        verify(countryRepository, times(1)).findByCountryCode(countryCode);
    }

    @Test
    public void verifyFindCountryByCountryCodeThrowsExceptionMessage() {
        String exceptionMessage = "Country with country code: BG is not found!";
        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class,  () -> {
            countryService.findByCountryCode("BG");
        });
        assertEquals(exception.getMessage(), exceptionMessage);
    }

    @Test
    public void verifyFindCountryByCountryCodeThrowsExceptionLength() {
        String exceptionMessage = "The country code should only be two capital letters!";
        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            countryService.findByCountryCode("BGN");
        });
        assertEquals(exception.getMessage(), exceptionMessage);
    }

    @Test
    public void verifyFindCountryByCountryCodeThrowsExceptionCapitalLetter() {
        String exceptionMessage = "The country code should only be two capital letters!";
        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            countryService.findByCountryCode("bg");
        });
        assertEquals(exception.getMessage(), exceptionMessage);
    }

    @Test
    public void verifyFindCountryByCountryCodeThrowsExceptionBlankSpace() {
        String exceptionMessage = "The country code should only be two capital letters!";
        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
           countryService.findByCountryCode(" G");
        });
    }
}
