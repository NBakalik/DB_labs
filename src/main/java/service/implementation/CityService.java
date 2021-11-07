package service.implementation;

import DAO.GeneralDAO;
import DAO.implementation.CityDaoImpl;
import model.City;
import service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class CityService implements GeneralService<City> {

    private final GeneralDAO generalDAO = new CityDaoImpl();

    @Override
    public List<City> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public City findById(Integer id) throws SQLException {
        return (City) generalDAO.findById(id);
    }

    @Override
    public void create(City city) throws SQLException {
        generalDAO.create(city);
    }

    @Override
    public void update(City city) throws SQLException {
        generalDAO.update(city);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
