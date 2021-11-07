package DAO.implementation;

import DAO.GeneralDAO;
import model.Item;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements GeneralDAO<Item> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.item";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.item WHERE id=?";
    private static final String CREATE = "INSERT INTO bakalik_db.item" +
            "(name, description, image, brand, model, configuration, price, sub_category_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE bakalik_db.item" +
            " SET name = ?, description = ?, image = ?, brand = ?, model = ?, configuration = ?, price = ?, sub_category_id = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.item WHERE (`id` = ?);";

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> items = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    Item item = new Item(resultSet.getInt("id"),
                            resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("image"),
                            resultSet.getString("brand"), resultSet.getString("model"), resultSet.getString("configuration"),
                            resultSet.getDouble("price"), resultSet.getInt("sub_category_id"));
                    items.add(item);
                }
            }
        }
        return items;
    }

    @Override
    public Item findById(Integer id) throws SQLException {
        Item item = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item = new Item(resultSet.getInt("id"),
                            resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("image"),
                            resultSet.getString("brand"), resultSet.getString("model"), resultSet.getString("configuration"),
                            resultSet.getDouble("price"), resultSet.getInt("sub_category_id"));
                }
            }
        }
        return item;
    }

    @Override
    public void create(Item item) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setString(3, item.getImage());
            statement.setString(4, item.getBrand());
            statement.setString(5, item.getModel());
            statement.setString(6, item.getConfiguration());
            statement.setDouble(7, item.getPrice());
            statement.setInt(8, item.getSubCategory());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Item item) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setString(3, item.getImage());
            statement.setString(4, item.getBrand());
            statement.setString(5, item.getModel());
            statement.setString(6, item.getConfiguration());
            statement.setDouble(7, item.getPrice());
            statement.setInt(8, item.getSubCategory());
            statement.setInt(9, item.getId());
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

