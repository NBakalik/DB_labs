package com.bakalik.service.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.DAO.implementation.OrderDaoImpl;
import com.bakalik.entity.Order;
import com.bakalik.service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class OrderService implements GeneralService<Order> {

    private final GeneralDAO generalDAO = new OrderDaoImpl();

    @Override
    public List<Order> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public Order findById(Integer id) throws SQLException {
        return (Order) generalDAO.findById(id);
    }

    @Override
    public void create(Order order) throws SQLException {
        generalDAO.create(order);
    }

    @Override
    public void update(Order order) throws SQLException {
        generalDAO.update(order);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
