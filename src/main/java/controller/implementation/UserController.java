package controller.implementation;

import controller.GeneralController;
import model.User;
import service.GeneralService;
import service.implementation.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserController implements GeneralController<User> {

    private final GeneralService generalService = new UserService();

    @Override
    public List<User> findAll() throws SQLException {
        return generalService.findAll();
    }

    @Override
    public User findById(Integer id) throws SQLException {
        return (User) generalService.findById(id);
    }

    @Override
    public void create(User user) throws SQLException {
        generalService.create(user);
    }

    @Override
    public void update(User user) throws SQLException {
        generalService.update(user);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        generalService.delete(id);
    }
}
