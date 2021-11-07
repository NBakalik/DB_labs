package service.implementation;

import DAO.GeneralDAO;
import DAO.implementation.CategoryDaoImpl;
import model.Category;
import service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements GeneralService<Category> {

    private final GeneralDAO generalDAO = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public Category findById(Integer id) throws SQLException {
        return (Category) generalDAO.findById(id);
    }

    @Override
    public void create(Category category) throws SQLException {
        generalDAO.create(category);
    }

    @Override
    public void update(Category category) throws SQLException {
        generalDAO.update(category);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
