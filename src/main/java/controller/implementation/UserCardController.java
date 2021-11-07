package controller.implementation;

import controller.GeneralController;
import model.UserCard;
import service.GeneralService;
import service.implementation.UserCardService;

import java.sql.SQLException;
import java.util.List;

public class UserCardController implements GeneralController<UserCard> {

    private final GeneralService generalService = new UserCardService();

    @Override
    public List<UserCard> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public UserCard findById(Integer id) throws SQLException {
        return (UserCard) generalService.findById(id);
    }

    @Override
    public void create(UserCard userCard) throws SQLException {
        generalService.create(userCard);
    }

    @Override
    public void update(UserCard userCard) throws SQLException {
        generalService.update(userCard);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
