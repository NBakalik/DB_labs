package com.bakalik.DAO.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.entity.Region;
import com.bakalik.persistant.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegionDaoImpl implements GeneralDAO<Region> {
    private final SessionFactory sessionFactory = Util.getOurSessionFactory();

    @Override
    public List<Region> findAll() throws SQLException {
        List<Region> regions = (List<Region>) sessionFactory.openSession().createQuery("from Region").list();
        return regions;
    }

    @Override
    public Region findById(Integer id) throws SQLException {
        Region region = sessionFactory.openSession().get(Region.class, id);
        return region;
    }

    @Override
    public void create(Region region) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(region);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Region region) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(region);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Region region = session.get(Region.class, id);
            if (region != null) {
                session.delete(region);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

