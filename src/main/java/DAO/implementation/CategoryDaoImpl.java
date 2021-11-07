package DAO.implementation;

import DAO.GeneralDAO;
import model.Category;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements GeneralDAO<Category> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.category";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.category WHERE id=?";
    private static final String CREATE = "INSERT INTO bakalik_db.category" +
            "(name) VALUES (?);";
    private static final String UPDATE = "UPDATE bakalik_db.category" +
            " SET name = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.category WHERE (`id` = ?);";

    @Override
    public List<Category> findAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    Category category = new Category(resultSet.getInt("id"),
                            resultSet.getString("name"));
                    categories.add(category);
                }
            }
        }
        return categories;
    }

    @Override
    public Category findById(Integer id) throws SQLException {
        Category category = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    category = new Category(resultSet.getInt("id"),
                            resultSet.getString("name"));
                }
            }
        }
        return category;
    }

    @Override
    public void create(Category category) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, category.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Category category) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, category.getName());
            statement.setInt(2, category.getId());
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


