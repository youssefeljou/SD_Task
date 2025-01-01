package com.example.demo.Mapper;

import com.example.demo.DTOs.CountryDto;
import com.example.demo.Entities.Country;
import com.example.demo.Mappers.CountryMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class CountryMapperTest {

    @Autowired
    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);

    @Test
    void mapToDtoTest() {
        Country country = new Country(1,"us");
        CountryDto countryDto = countryMapper.mapToDto(country);
        assertEquals(country.getId(), countryDto.id());
        assertEquals("name of "+country.getIsoCode(), countryDto.isoCode());
    }
}
