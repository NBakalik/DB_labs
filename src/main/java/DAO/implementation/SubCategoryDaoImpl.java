package DAO.implementation;

import DAO.GeneralDAO;
import model.SubCategory;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryDaoImpl implements GeneralDAO<SubCategory> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.sub_category";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.sub_category WHERE id=?";
    private static final String CREATE = "INSERT INTO bakalik_db.sub_category" +
            "(category_id, name) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE bakalik_db.sub_category" +
            " SET category_id = ?, name = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.sub_category WHERE (`id` = ?);";

    @Override
    public List<SubCategory> findAll() throws SQLException {
        List<SubCategory> subCategories = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    SubCategory subCategory = new SubCategory(resultSet.getInt("id"),
                            resultSet.getInt("category_id"), resultSet.getString("name"));
                    subCategories.add(subCategory);
                }
            }
        }
        return subCategories;
    }

    @Override
    public SubCategory findById(Integer id) throws SQLException {
        SubCategory subCategory = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    subCategory =  new SubCategory(resultSet.getInt("id"),
                            resultSet.getInt("category_id"), resultSet.getString("name"));
                }
            }
        }
        return subCategory;
    }

    @Override
    public void create(SubCategory subCategory) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setInt(1, subCategory.getCategoryId());
            statement.setString(2, subCategory.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(SubCategory subCategory) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(1, subCategory.getCategoryId());
            statement.setString(2, subCategory.getName());
            statement.setInt(3, subCategory.getId());
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

