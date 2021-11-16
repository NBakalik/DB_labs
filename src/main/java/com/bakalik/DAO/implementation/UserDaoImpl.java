package com.bakalik.DAO.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.entity.User;
import com.bakalik.persistant.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements GeneralDAO<User> {
    private final SessionFactory sessionFactory = Util.getOurSessionFactory();

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = (List<User>) sessionFactory.openSession().createQuery("from User").list();
        return users;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        User user = sessionFactory.openSession().get(User.class, id);
        return user;
    }

    @Override
    public void create(User user) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

