package com.example.demo.Mapper;

import com.example.demo.DTOs.CompanyDto;
import com.example.demo.DTOs.CountryDto;
import com.example.demo.Entities.Company;
import com.example.demo.Entities.Country;
import com.example.demo.Mappers.CompanyMapper;
import com.example.demo.Services.CountryService;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyMapperTest {
    @Autowired
    private CountryService countryService;


    @Autowired
    private final CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);

    @Test
    void shouldMapCompanyToCompanyDto() {
        // given
        Country country = new Country();
        country.setId(1);
        country.setIsoCode("US");

        Company company = new Company();
        company.setId(1);
        company.setName("Test Company");
        company.setCountry(country);


        CompanyDto companyDto = companyMapper.mapToDto(company);


        assertEquals(company.getId(), companyDto.id());
        assertEquals(company.getName(), companyDto.name());
        assertEquals(company.getCountry().getId(), companyDto.country().id());
        assertEquals(company.getCountry().getIsoCode(), companyDto.country().isoCode());
    }

    @Test
    void shouldMapCompanyDtoToCompany() {
        // given
        CountryDto countryDto = new CountryDto(1, "US");
        CompanyDto companyDto = new CompanyDto(1, "Test Company", countryDto);


        Company company = companyMapper.mapToDto(companyDto);


        assertEquals(companyDto.id(), company.getId());
        assertEquals(companyDto.name(), company.getName());
        assertEquals(companyDto.country().id(), company.getCountry().getId());
        assertEquals(companyDto.country().isoCode(),company.getCountry().getIsoCode());
    }
}
