package DAO.implementation;

import DAO.GeneralDAO;
import model.Order;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements GeneralDAO<Order> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.order";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.order WHERE id=?";
    private static final String CREATE = "INSERT INTO bakalik_db.order" +
            "(user_id, time, city_id, delivery_id, total_price, order_status) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE bakalik_db.order" +
            " SET user_id = ?, time = ?, city_id = ?, delivery_id = ?, total_price = ?, order_status = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.order WHERE (`id` = ?);";

    @Override
    public List<Order> findAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    Order order = new Order(resultSet.getInt("id"),
                            resultSet.getInt("user_id"), resultSet.getString("time"), resultSet.getInt("city_id"),
                            resultSet.getInt("delivery_id"), resultSet.getDouble("total_price"), resultSet.getInt("order_status"));
                    orders.add(order);
                }
            }
        }
        return orders;
    }

    @Override
    public Order findById(Integer id) throws SQLException {
        Order order = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    order = new Order(resultSet.getInt("id"),
                            resultSet.getInt("user_id"), resultSet.getString("time"), resultSet.getInt("city_id"),
                            resultSet.getInt("delivery_id"), resultSet.getDouble("total_price"), resultSet.getInt("order_status")); }
            }
        }
        return order;
    }

    @Override
    public void create(Order order) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setInt(1, order.getUserId());
            statement.setString(2, order.getTime());
            statement.setInt(3, order.getCity());
            statement.setInt(4, order.getDeliveryId());
            statement.setDouble(5, order.getTotalPrice());
            statement.setInt(6, order.getOrderStatus());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Order order) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(1, order.getUserId());
            statement.setString(2, order.getTime());
            statement.setInt(3, order.getCity());
            statement.setInt(4, order.getDeliveryId());
            statement.setDouble(5, order.getTotalPrice());
            statement.setInt(6, order.getOrderStatus());
            statement.setInt(7, order.getId());
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

