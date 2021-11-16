package com.bakalik.service.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.DAO.implementation.SubCategoryDaoImpl;
import com.bakalik.entity.SubCategory;
import com.bakalik.service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class SubCategoryService implements GeneralService<SubCategory> {

    private final GeneralDAO generalDAO = new SubCategoryDaoImpl();

    @Override
    public List<SubCategory> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public SubCategory findById(Integer id) throws SQLException {
        return (SubCategory) generalDAO.findById(id);
    }

    @Override
    public void create(SubCategory subCategory) throws SQLException {
        generalDAO.create(subCategory);
    }

    @Override
    public void update(SubCategory subCategory) throws SQLException {
        generalDAO.update(subCategory);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
