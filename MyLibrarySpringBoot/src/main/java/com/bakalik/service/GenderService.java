package com.bakalik.service;

import com.bakalik.repo.GenderRepository;
import com.bakalik.domain.Gender;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GenderService extends GeneralService<Gender, Integer> {
    @Autowired
    public GenderRepository genderRepository;

    @Override
    protected JpaRepository<Gender, Integer> getRepo() {
        return genderRepository;
    }
}
