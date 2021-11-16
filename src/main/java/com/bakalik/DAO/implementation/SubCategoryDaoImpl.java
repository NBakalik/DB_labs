package com.bakalik.DAO.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.entity.SubCategory;
import com.bakalik.persistant.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryDaoImpl implements GeneralDAO<SubCategory> {
    private final SessionFactory sessionFactory = Util.getOurSessionFactory();

    @Override
    public List<SubCategory> findAll() throws SQLException {
        List<SubCategory> subCategories = (List<SubCategory>) sessionFactory.openSession().createQuery("from SubCategory").list();
        return subCategories;
    }

    @Override
    public SubCategory findById(Integer id) throws SQLException {
        SubCategory subCategory = sessionFactory.openSession().get(SubCategory.class, id);
        return subCategory;
    }

    @Override
    public void create(SubCategory subCategory) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(subCategory);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(SubCategory subCategory) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(subCategory);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            SubCategory subCategory = session.get(SubCategory.class, id);
            if (subCategory != null) {
                session.delete(subCategory);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

