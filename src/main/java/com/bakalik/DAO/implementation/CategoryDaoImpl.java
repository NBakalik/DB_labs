package com.bakalik.DAO.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.entity.Category;
import com.bakalik.persistant.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.List;

public class CategoryDaoImpl implements GeneralDAO<Category> {
    private final SessionFactory sessionFactory = Util.getOurSessionFactory();

    @Override
    public List<Category> findAll() throws SQLException {
        List<Category> categories = (List<Category>) sessionFactory.openSession().createQuery("from Category ").list();
        return categories;
    }

    @Override
    public Category findById(Integer id) throws SQLException {
        Category category = sessionFactory.openSession().get(Category.class, id);
        return category;
    }

    @Override
    public void create(Category category) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Category category = session.get(Category.class, id);
            if (category != null) {
                session.delete(category);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


