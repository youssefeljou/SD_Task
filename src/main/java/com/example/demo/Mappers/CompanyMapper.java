package com.example.demo.Mappers;


import com.example.demo.DTOs.CompanyDto;
import com.example.demo.Entities.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = CountryMapper.class)
public interface CompanyMapper {

    CompanyDto mapToDto(Company company);

    Company mapToDto(CompanyDto companyDto);
}
