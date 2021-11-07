package DAO.implementation;

import DAO.GeneralDAO;
import model.Region;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegionDaoImpl implements GeneralDAO<Region> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.region";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.region WHERE id=?";
    private static final String CREATE = "INSERT INTO bakalik_db.region" +
            "(region) VALUES (?);";
    private static String UPDATE = "UPDATE bakalik_db.region" +
            " SET region = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.region WHERE (`id` = ?);";

    @Override
    public List<Region> findAll() throws SQLException {
        List<Region> regions = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    Region region = new Region(resultSet.getInt("id"),
                            resultSet.getString("region"));
                    regions.add(region);
                }
            }
        }
        return regions;
    }

    @Override
    public Region findById(Integer id) throws SQLException {
        Region region = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    region = new Region(resultSet.getInt("id"),
                            resultSet.getString("region"));
                }
            }
        }
        return region;
    }

    @Override
    public void create(Region region) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, region.getRegion());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Region region) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, region.getRegion());
            statement.setInt(2, region.getId());
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

