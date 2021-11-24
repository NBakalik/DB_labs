package com.bakalik.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class GeneralService<T, ID> {
    protected abstract JpaRepository<T, ID> getRepo();

    public List<T> getAll() {
        return getRepo().findAll();
    }

    public T getById(ID id) {
        T object = getRepo().findById(id).orElse(null);
        if (object == null)
            throw new NoSuchElementException();
        return object;
    }

    public void add(T object) {
        getRepo().save(object);
    }

    public T update(T object, ID id) {
        T existObj = getRepo().findById(id).orElse(null);
        if (existObj == null) {
            throw new NoSuchElementException();
        } else {
            return getRepo().save(object);
        }
    }

    public T delete(ID id) {
        T existObj = getRepo().findById(id).orElse(null);
        if (existObj == null) {
            throw new NoSuchElementException();
        } else {
            getRepo().deleteById(id);
            return existObj;
        }
    }
}

