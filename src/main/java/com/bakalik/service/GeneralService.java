package com.bakalik.service;

import java.sql.SQLException;
import java.util.List;

public interface GeneralService<T> {

    List<T> findAll() throws SQLException;

    T findById(Integer id) throws SQLException;

    void create(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(Integer id) throws SQLException;

}

