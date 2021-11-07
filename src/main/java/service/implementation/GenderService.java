package service.implementation;

import DAO.GeneralDAO;
import DAO.implementation.GenderDaoImpl;
import model.Gender;
import service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class GenderService implements GeneralService<Gender> {

    private final GeneralDAO generalDAO = new GenderDaoImpl();

    @Override
    public List<Gender> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public Gender findById(Integer id) throws SQLException {
        return (Gender) generalDAO.findById(id);
    }

    @Override
    public void create(Gender gender) throws SQLException {
        generalDAO.create(gender);
    }

    @Override
    public void update(Gender gender) throws SQLException {
        generalDAO.update(gender);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
