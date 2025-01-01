package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public String getName(String isoCode) {

        return "name of " + isoCode;
    }
}
