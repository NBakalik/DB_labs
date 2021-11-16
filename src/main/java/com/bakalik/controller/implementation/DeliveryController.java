package com.bakalik.controller.implementation;

import com.bakalik.controller.GeneralController;
import com.bakalik.entity.Delivery;
import com.bakalik.service.GeneralService;
import com.bakalik.service.implementation.DeliveryService;

import java.sql.SQLException;
import java.util.List;

public class DeliveryController implements GeneralController<Delivery> {

    private final GeneralService generalService = new DeliveryService();

    @Override
    public List<Delivery> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public Delivery findById(Integer id) throws SQLException {
        return (Delivery) generalService.findById(id);
    }

    @Override
    public void create(Delivery delivery) throws SQLException {
        generalService.create(delivery);
    }

    @Override
    public void update(Delivery delivery) throws SQLException {
        generalService.update(delivery);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
