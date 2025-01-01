package com.example.demo.Mappers;

import com.example.demo.DTOs.CountryDto;
import com.example.demo.Entities.Country;
import com.example.demo.Services.CountryService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = CountryService.class)
public interface CountryMapper {

    @Mapping(target = "isoCode", expression = "java(country.getIsoCode())")
    CountryDto mapToDto(Country country);

    @Mapping(target = "isoCode", expression = "java(countryDto.isoCode())")
    Country mapToDto(CountryDto countryDto);
}