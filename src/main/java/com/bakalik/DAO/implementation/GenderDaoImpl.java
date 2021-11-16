package com.bakalik.DAO.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.entity.Gender;
import com.bakalik.persistant.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenderDaoImpl implements GeneralDAO<Gender> {
    private final SessionFactory sessionFactory = Util.getOurSessionFactory();

    @Override
    public List<Gender> findAll() throws SQLException {
        List<Gender> genders = (List<Gender>) sessionFactory.openSession().createQuery("from Gender ").list();
        return genders;
    }

    @Override
    public Gender findById(Integer id) throws SQLException {
        Gender gender = sessionFactory.openSession().get(Gender.class, id);
        return gender;
    }

    @Override
    public void create(Gender gender) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(gender);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Gender gender) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(gender);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Gender gender = session.get(Gender.class, id);
            if (gender != null) {
                session.delete(gender);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

