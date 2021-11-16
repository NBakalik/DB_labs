package com.bakalik.controller.implementation;

import com.bakalik.controller.GeneralController;
import com.bakalik.entity.Category;
import com.bakalik.service.GeneralService;
import com.bakalik.service.implementation.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryController implements GeneralController<Category> {

    private final GeneralService generalService = new CategoryService();

    @Override
    public List<Category> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public Category findById(Integer id) throws SQLException {
        return (Category) generalService.findById(id);
    }

    @Override
    public void create(Category category) throws SQLException {
        generalService.create(category);
    }

    @Override
    public void update(Category category) throws SQLException {
        generalService.update(category);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
