package DAO.implementation;

import DAO.GeneralDAO;
import model.OrderStatus;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderStatusDaoImpl implements GeneralDAO<OrderStatus> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.order_status";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.order_status WHERE id=?";
    private static final String CREATE = "INSERT INTO bakalik_db.order_status" +
            "(status) VALUES (?);";
    private static final String UPDATE = "UPDATE bakalik_db.order_status" +
            " SET status = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.order_status WHERE (`id` = ?);";

    @Override
    public List<OrderStatus> findAll() throws SQLException {
        List<OrderStatus> orderStatuses = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    OrderStatus orderStatus = new OrderStatus(resultSet.getInt("id"),
                            resultSet.getString("status"));
                    orderStatuses.add(orderStatus);
                }
            }
        }
        return orderStatuses;
    }

    @Override
    public OrderStatus findById(Integer id) throws SQLException {
        OrderStatus orderStatus = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    orderStatus = new OrderStatus(resultSet.getInt("id"),
                            resultSet.getString("status"));
                }
            }
        }
        return orderStatus;
    }

    @Override
    public void create(OrderStatus orderStatus) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, orderStatus.getStatus());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(OrderStatus orderStatus) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, orderStatus.getStatus());
            statement.setInt(2, orderStatus.getId());
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

