package controller.implementation;

import controller.GeneralController;
import model.SubCategory;
import service.GeneralService;
import service.implementation.SubCategoryService;

import java.sql.SQLException;
import java.util.List;

public class SubCategoryController implements GeneralController<SubCategory> {

    private final GeneralService generalService = new SubCategoryService();

    @Override
    public List<SubCategory> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public SubCategory findById(Integer id) throws SQLException {
        return (SubCategory) generalService.findById(id);
    }

    @Override
    public void create(SubCategory subCategory) throws SQLException {
        generalService.create(subCategory);
    }

    @Override
    public void update(SubCategory subCategory) throws SQLException {
        generalService.update(subCategory);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
