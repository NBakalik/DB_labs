package com.bakalik.controller.implementation;

import com.bakalik.controller.GeneralController;
import com.bakalik.entity.Order;
import com.bakalik.service.GeneralService;
import com.bakalik.service.implementation.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderController implements GeneralController<Order> {

    private final GeneralService generalService = new OrderService();

    @Override
    public List<Order> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public Order findById(Integer id) throws SQLException {
        return (Order) generalService.findById(id);
    }

    @Override
    public void create(Order order) throws SQLException {
        generalService.create(order);
    }

    @Override
    public void update(Order order) throws SQLException {
        generalService.update(order);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
