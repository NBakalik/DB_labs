package com.bakalik.service.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.DAO.implementation.RegionDaoImpl;
import com.bakalik.entity.Region;
import com.bakalik.service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class RegionService implements GeneralService<Region> {

    private final GeneralDAO generalDAO = new RegionDaoImpl();

    @Override
    public List<Region> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public Region findById(Integer id) throws SQLException {
        return (Region) generalDAO.findById(id);
    }

    @Override
    public void create(Region region) throws SQLException {
        generalDAO.create(region);
    }

    @Override
    public void update(Region region) throws SQLException {
        generalDAO.update(region);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
