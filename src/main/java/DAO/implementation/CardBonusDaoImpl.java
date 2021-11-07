package DAO.implementation;

import DAO.GeneralDAO;
import model.CardBonus;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardBonusDaoImpl implements GeneralDAO<CardBonus> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.card_bonus";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.card_bonus WHERE id=?";
    private static final String CREATE = "INSERT INTO bakalik_db.card_bonus " +
            "(name, discount) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE bakalik_db.card_bonus" +
            " SET name = ?, discount = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.card_bonus WHERE (`id` = ?);";

    @Override
    public List<CardBonus> findAll() throws SQLException {
        List<CardBonus> cardBonuses = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    CardBonus cardBonus = new CardBonus(resultSet.getInt("id"),
                            resultSet.getString("name"), resultSet.getDouble("discount"));
                    cardBonuses.add(cardBonus);
                }
            }
        }
        return cardBonuses;
    }

    @Override
    public CardBonus findById(Integer id) throws SQLException {
        CardBonus cardBonus = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cardBonus = new CardBonus(resultSet.getInt("id"),
                            resultSet.getString("name"), resultSet.getDouble("discount"));
                }
            }
        }
        return cardBonus;
    }

    @Override
    public void create(CardBonus cardBonus) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, cardBonus.getName());
            statement.setDouble(2, cardBonus.getDiscount());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(CardBonus cardBonus) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, cardBonus.getName());
            statement.setDouble(2, cardBonus.getDiscount());
            statement.setInt(3, cardBonus.getId());
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

