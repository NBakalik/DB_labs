package com.bakalik.controller.implementation;

import com.bakalik.controller.GeneralController;
import com.bakalik.entity.UserCard;
import com.bakalik.service.GeneralService;
import com.bakalik.service.implementation.UserCardService;

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
