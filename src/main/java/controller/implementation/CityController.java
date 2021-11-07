package controller.implementation;

import controller.GeneralController;
import model.City;
import service.GeneralService;
import service.implementation.CityService;

import java.sql.SQLException;
import java.util.List;

public class CityController implements GeneralController<City> {

    private final GeneralService generalService = new CityService();

    @Override
    public List<City> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public City findById(Integer id) throws SQLException {
        return (City) generalService.findById(id);
    }

    @Override
    public void create(City city) throws SQLException {
        generalService.create(city);
    }

    @Override
    public void update(City city) throws SQLException {
        generalService.update(city);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
