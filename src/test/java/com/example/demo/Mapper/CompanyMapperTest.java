package com.example.demo.Mapper;

import com.example.demo.DTOs.CompanyDto;
import com.example.demo.Entities.Company;
import com.example.demo.Entities.Country;
import com.example.demo.Mappers.CompanyMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyMapperTest {
    @Autowired
    private final CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);
    @Test
    void mapToDtoTest() {
        Country country = new Country(1, "US");
        Company company = new Company(1, "CompanyName", country);
        CompanyDto companyDto = companyMapper.mapToDto(company);
        assertEquals("CompanyName", companyDto.name());
        assertEquals("name of US", companyDto.country().isoCode());
    }

}
