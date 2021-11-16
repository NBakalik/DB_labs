package com.bakalik.service.implementation;

import com.bakalik.DAO.GeneralDAO;
import com.bakalik.DAO.implementation.ItemDaoImpl;
import com.bakalik.entity.Item;
import com.bakalik.service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class ItemService implements GeneralService<Item> {

    private final GeneralDAO generalDAO = new ItemDaoImpl();

    @Override
    public List<Item> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public Item findById(Integer id) throws SQLException {
        return (Item) generalDAO.findById(id);
    }

    @Override
    public void create(Item item) throws SQLException {
        generalDAO.create(item);
    }

    @Override
    public void update(Item item) throws SQLException {
        generalDAO.update(item);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
