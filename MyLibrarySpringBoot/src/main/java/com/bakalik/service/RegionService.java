package com.bakalik.service;

import com.bakalik.repo.RegionRepository;
import com.bakalik.domain.Region;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegionService extends GeneralService<Region, Integer> {
    @Autowired
    public RegionRepository regionRepository;

    @Override
    protected JpaRepository<Region, Integer> getRepo() {
        return regionRepository;
    }
}
