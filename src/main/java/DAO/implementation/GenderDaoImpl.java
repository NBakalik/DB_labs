package DAO.implementation;

import DAO.GeneralDAO;
import model.Gender;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenderDaoImpl implements GeneralDAO<Gender> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.gender";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.gender WHERE id=?";
    private static final String CREATE = "INSERT INTO bakalik_db.gender" +
            "(gender) VALUES (?);";
    private static final String UPDATE = "UPDATE bakalik_db.gender" +
            " SET gender = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.gender WHERE (`id` = ?);";

    @Override
    public List<Gender> findAll() throws SQLException {
        List<Gender> genders = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    Gender gender = new Gender(resultSet.getInt("id"),
                            resultSet.getString("gender"));
                    genders.add(gender);
                }
            }
        }
        return genders;
    }

    @Override
    public Gender findById(Integer id) throws SQLException {
        Gender gender = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    gender = new Gender(resultSet.getInt("id"),
                            resultSet.getString("gender"));
                }
            }
        }
        return gender;
    }

    @Override
    public void create(Gender gender) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, gender.getGender());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Gender gender) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, gender.getGender());
            statement.setInt(2, gender.getId());
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

