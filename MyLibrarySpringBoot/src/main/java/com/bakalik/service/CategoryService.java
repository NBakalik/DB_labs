package com.bakalik.service;

import com.bakalik.repo.CategoryRepository;
import com.bakalik.domain.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryService extends GeneralService<Category, Integer> {
    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    protected JpaRepository<Category, Integer> getRepo() {
        return categoryRepository;
    }
}
