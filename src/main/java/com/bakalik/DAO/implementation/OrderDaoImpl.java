package com.bakalik.DAO.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.entity.Order;
import com.bakalik.persistant.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements GeneralDAO<Order> {
    private final SessionFactory sessionFactory = Util.getOurSessionFactory();

    @Override
    public List<Order> findAll() throws SQLException {
        List<Order> orders = (List<Order>) sessionFactory.openSession().createQuery("from Order").list();
        return orders;
    }

    @Override
    public Order findById(Integer id) throws SQLException {
        Order order = sessionFactory.openSession().get(Order.class, id);
        return order;
    }

    @Override
    public void create(Order order) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order order) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Order order = session.get(Order.class, id);
            if (order != null) {
                session.delete(order);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

