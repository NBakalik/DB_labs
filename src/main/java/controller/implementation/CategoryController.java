package controller.implementation;

import controller.GeneralController;
import model.Category;
import service.GeneralService;
import service.implementation.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryController implements GeneralController<Category> {

    private final GeneralService generalService = new CategoryService();

    @Override
    public List<Category> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public Category findById(Integer id) throws SQLException {
        return (Category) generalService.findById(id);
    }

    @Override
    public void create(Category category) throws SQLException {
        generalService.create(category);
    }

    @Override
    public void update(Category category) throws SQLException {
        generalService.update(category);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
