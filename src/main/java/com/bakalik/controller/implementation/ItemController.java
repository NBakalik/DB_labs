package com.bakalik.controller.implementation;

import com.bakalik.controller.GeneralController;
import com.bakalik.entity.Item;
import com.bakalik.service.GeneralService;
import com.bakalik.service.implementation.ItemService;

import java.sql.SQLException;
import java.util.List;

public class ItemController implements GeneralController<Item> {

    private final GeneralService generalService = new ItemService();

    @Override
    public List<Item> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public Item findById(Integer id) throws SQLException {
        return (Item) generalService.findById(id);
    }

    @Override
    public void create(Item item) throws SQLException {
        generalService.create(item);
    }

    @Override
    public void update(Item item) throws SQLException {
        generalService.update(item);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
