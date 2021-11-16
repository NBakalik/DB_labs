package com.bakalik.DAO.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.entity.OrderStatus;
import com.bakalik.persistant.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderStatusDaoImpl implements GeneralDAO<OrderStatus> {
    private final SessionFactory sessionFactory = Util.getOurSessionFactory();

    @Override
    public List<OrderStatus> findAll() throws SQLException {
        List<OrderStatus> orderStatuses = (List<OrderStatus>) sessionFactory.openSession().createQuery("from OrderStatus").list();
        return orderStatuses;
    }

    @Override
    public OrderStatus findById(Integer id) throws SQLException {
        OrderStatus orderStatus = sessionFactory.openSession().get(OrderStatus.class, id);
        return orderStatus;
    }

    @Override
    public void create(OrderStatus orderStatus) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(orderStatus);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(OrderStatus orderStatus) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(orderStatus);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            OrderStatus orderStatus = session.get(OrderStatus.class, id);
            if (orderStatus != null) {
                session.delete(orderStatus);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

