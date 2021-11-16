package com.bakalik.DAO.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.entity.Item;
import com.bakalik.persistant.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements GeneralDAO<Item> {
    private final SessionFactory sessionFactory = Util.getOurSessionFactory();

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> items = (List<Item>) sessionFactory.openSession().createQuery("from Item ").list();
        return items;
    }

    @Override
    public Item findById(Integer id) throws SQLException {
        Item item = sessionFactory.openSession().get(Item.class, id);
        return item;
    }

    @Override
    public void create(Item item) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Item item) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Item item = session.get(Item.class, id);
            if (item != null) {
                session.delete(item);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

