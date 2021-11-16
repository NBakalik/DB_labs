package com.bakalik.DAO.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.entity.UserCard;
import com.bakalik.persistant.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCardDaoImpl implements GeneralDAO<UserCard> {
    private final SessionFactory sessionFactory = Util.getOurSessionFactory();

    @Override
    public List<UserCard> findAll() throws SQLException {
        List<UserCard> userCards = (List<UserCard>) sessionFactory.openSession().createQuery("from UserCard").list();
        return userCards;
    }

    @Override
    public UserCard findById(Integer id) throws SQLException {
        UserCard userCard = sessionFactory.openSession().get(UserCard.class, id);
        return userCard;
    }

    @Override
    public void create(UserCard userCard) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(userCard);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(UserCard userCard) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(userCard);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            UserCard userCard = session.get(UserCard.class, id);
            if (userCard != null) {
                session.delete(userCard);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

