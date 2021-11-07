package DAO.implementation;

import DAO.GeneralDAO;
import model.User;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements GeneralDAO<User> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.user";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.user WHERE id=?";
    private static final String CREATE = "INSERT INTO bakalik_db.user" +
            "(name, surname, birthday, gender_id, city_id, street_address, zip_code, phone, email, registered_at, " +
            "user_card_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE bakalik_db.user" +
            " SET name = ?, surname = ?, birthday = ?, gender_id = ?, city_id = ?, street_address = ?, zip_code = ?, " +
            "phone = ?, email = ?, registered_at = ?, user_card_id = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.user WHERE (`id` = ?);";

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    User user = new User(resultSet.getInt("id"),
                            resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("birthday"),
                            resultSet.getInt("gender_id"), resultSet.getInt("city_id"), resultSet.getString("street_address"),
                            resultSet.getString("zip_code"), resultSet.getString("phone"), resultSet.getString("email"),
                            resultSet.getString("registered_at"), resultSet.getInt("user_card_id"));
                    users.add(user);
                }
            }
        }
        return users;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        User user = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    user = new User(resultSet.getInt("id"),
                            resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("birthday"),
                            resultSet.getInt("gender_id"), resultSet.getInt("city_id"), resultSet.getString("street_address"),
                            resultSet.getString("zip_code"), resultSet.getString("phone"), resultSet.getString("email"),
                            resultSet.getString("registered_at"), resultSet.getInt("user_card_id"));
                }
            }
        }
        return user;
    }

    @Override
    public void create(User user) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getDate());
            statement.setInt(4, user.getGenderId());
            statement.setDouble(5, user.getCityId());
            statement.setString(6, user.getStreetAddress());
            statement.setString(7, user.getZipCode());
            statement.setString(8, user.getPhone());
            statement.setString(9, user.getEmail());
            statement.setString(10, user.getRegisteredAt());
            statement.setInt(11, user.getUserCardId());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(User user) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getDate());
            statement.setInt(4, user.getGenderId());
            statement.setDouble(5, user.getCityId());
            statement.setString(6, user.getStreetAddress());
            statement.setString(7, user.getZipCode());
            statement.setString(8, user.getPhone());
            statement.setString(9, user.getEmail());
            statement.setString(10, user.getRegisteredAt());
            statement.setInt(11, user.getUserCardId());
            statement.setInt(12, user.getId());
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

