package com.bakalik.service.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.DAO.implementation.DeliveryDaoImpl;
import com.bakalik.entity.Delivery;
import com.bakalik.service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class DeliveryService implements GeneralService<Delivery> {

    private final GeneralDAO generalDAO = new DeliveryDaoImpl();

    @Override
    public List<Delivery> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public Delivery findById(Integer id) throws SQLException {
        return (Delivery) generalDAO.findById(id);
    }

    @Override
    public void create(Delivery delivery) throws SQLException {
        generalDAO.create(delivery);
    }

    @Override
    public void update(Delivery delivery) throws SQLException {
        generalDAO.update(delivery);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
