package com.bakalik.service;

import com.bakalik.repo.SubCategoryRepository;
import com.bakalik.domain.SubCategory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SubCategoryService extends GeneralService<SubCategory, Integer> {
    @Autowired
    public SubCategoryRepository subCategoryRepository;

    @Override
    protected JpaRepository<SubCategory, Integer> getRepo() {
        return subCategoryRepository;
    }
}
