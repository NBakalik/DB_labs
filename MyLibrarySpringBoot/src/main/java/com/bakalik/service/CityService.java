package com.bakalik.service;

import com.bakalik.repo.CityRepository;
import com.bakalik.domain.City;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CityService extends GeneralService<City, Integer> {
    @Autowired
    public CityRepository cityRepository;

    @Override
    protected JpaRepository<City, Integer> getRepo() {
        return cityRepository;
    }
}
