package service.implementation;

import DAO.GeneralDAO;
import DAO.implementation.ItemDaoImpl;
import model.Item;
import service.GeneralService;

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
