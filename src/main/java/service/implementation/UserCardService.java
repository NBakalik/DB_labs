package service.implementation;

import DAO.GeneralDAO;
import DAO.implementation.UserCardDaoImpl;
import model.UserCard;
import service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class UserCardService implements GeneralService<UserCard> {

    private final GeneralDAO generalDAO = new UserCardDaoImpl();

    @Override
    public List<UserCard> findAll() throws SQLException {
        return generalDAO.findAll();
    }

    @Override
    public UserCard findById(Integer id) throws SQLException {
        return (UserCard) generalDAO.findById(id);
    }

    @Override
    public void create(UserCard userCard) throws SQLException {
        generalDAO.create(userCard);
    }

    @Override
    public void update(UserCard userCard) throws SQLException {
        generalDAO.update(userCard);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalDAO.delete(id);
    }
}
