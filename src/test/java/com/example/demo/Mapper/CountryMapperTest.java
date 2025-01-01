package com.example.demo.Mapper;

import com.example.demo.DTOs.CountryDto;
import com.example.demo.Entities.Country;
import com.example.demo.Mappers.CountryMapper;
import com.example.demo.Services.CountryService;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class CountryMapperTest {


    @Autowired
    private CountryService countryService;


    @Autowired
    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);

    @Test
    void shouldMapCountryToCountryDto() {

        Country country = new Country(1,"us");



        CountryDto countryDto = countryMapper.mapToDto(country);



        assertEquals(country.getId(), countryDto.id());
        assertEquals(country.getIsoCode(), countryDto.isoCode());
    }

    @Test
    void shouldMapCountryDtoToCountry() {

        CountryDto countryDto = new CountryDto(1, "US");


        Country country = countryMapper.mapToDto(countryDto);


        assertEquals(countryDto.id(), country.getId());
        assertEquals(countryDto.isoCode(), country.getIsoCode());
    }
}
