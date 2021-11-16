package com.bakalik.service.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.DAO.implementation.UserDaoImpl;
import com.bakalik.entity.User;
import com.bakalik.service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements GeneralService<User> {

    private final GeneralDAO generalDAO = new UserDaoImpl();

    @Override
    public List<User> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public User findById(Integer id) throws SQLException {
        return (User) generalDAO.findById(id);
    }

    @Override
    public void create(User user) throws SQLException {
        generalDAO.create(user);
    }

    @Override
    public void update(User user) throws SQLException {
        generalDAO.update(user);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
