package com.bakalik.DAO.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.entity.Delivery;
import com.bakalik.persistant.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDaoImpl implements GeneralDAO<Delivery> {
    private final SessionFactory sessionFactory = Util.getOurSessionFactory();

    @Override
    public List<Delivery> findAll() throws SQLException {
        List<Delivery> deliveries = (List<Delivery>) sessionFactory.openSession().createQuery("from Delivery ").list();
        return deliveries;
    }

    @Override
    public Delivery findById(Integer id) throws SQLException {
        Delivery delivery = sessionFactory.openSession().get(Delivery.class, id);
        return delivery;
    }

    @Override
    public void create(Delivery delivery) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(delivery);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Delivery delivery) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(delivery);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Delivery delivery = session.get(Delivery.class, id);
            if (delivery != null) {
                session.delete(delivery);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

