package com.example.demo.Mappers;


import com.example.demo.DTOs.CompanyDto;
import com.example.demo.Entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = CountryMapper.class)
public interface CompanyMapper {

    CompanyDto mapToDto(Company company);

}
