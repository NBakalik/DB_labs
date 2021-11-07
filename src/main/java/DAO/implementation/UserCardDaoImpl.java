package DAO.implementation;

import DAO.GeneralDAO;
import model.UserCard;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCardDaoImpl implements GeneralDAO<UserCard> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.user_card";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.user_card WHERE id = ?";
    private static final String CREATE = "INSERT INTO bakalik_db.user_card" +
            "(name) VALUES (?);";
    private static final String UPDATE = "UPDATE bakalik_db.user_card" +
            " SET name = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.user_card WHERE (`id` = ?);";

    @Override
    public List<UserCard> findAll() throws SQLException {
        List<UserCard> userCards = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    UserCard userCard = new UserCard(resultSet.getInt("id"),
                            resultSet.getString("name"));
                    userCards.add(userCard);
                }
            }
        }
        return userCards;
    }

    @Override
    public UserCard findById(Integer id) throws SQLException {
        UserCard userCard = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    userCard = new UserCard(resultSet.getInt("id"),
                            resultSet.getString("name"));
                }
            }
        }
        return userCard;
    }

    @Override
    public void create(UserCard userCard) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, userCard.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(UserCard userCard) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, userCard.getName());
            statement.setInt(2, userCard.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

