package com.bakalik.controller.implementation;

import com.bakalik.controller.GeneralController;
import com.bakalik.entity.Gender;
import com.bakalik.service.GeneralService;
import com.bakalik.service.implementation.GenderService;

import java.sql.SQLException;
import java.util.List;

public class GenderController implements GeneralController<Gender> {

    private final GeneralService generalService = new GenderService();

    @Override
    public List<Gender> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public Gender findById(Integer id) throws SQLException {
        return (Gender) generalService.findById(id);
    }

    @Override
    public void create(Gender gender) throws SQLException {
        generalService.create(gender);
    }

    @Override
    public void update(Gender gender) throws SQLException {
        generalService.update(gender);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
