package com.bakalik.DAO.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.entity.City;
import com.bakalik.persistant.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements GeneralDAO<City> {
    private final SessionFactory sessionFactory = Util.getOurSessionFactory();

    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = (List<City>) sessionFactory.openSession().createQuery("from City").list();
        return cities;
    }

    @Override
    public City findById(Integer id) throws SQLException {
        City city = sessionFactory.openSession().get(City.class, id);
        return city;
    }

    @Override
    public void create(City city) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(City city) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(city);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            City city = session.get(City.class, id);
            if (city != null) {
                session.delete(city);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
