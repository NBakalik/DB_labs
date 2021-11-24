package com.bakalik.controller;

import com.bakalik.service.GeneralService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class GeneralController<T, ID> {
    protected abstract GeneralService<T, ID> getService();

    @GetMapping("/{id}")
    public Object getById(@PathVariable(name = "id") ID id) {
        if (getService().getById(id) != null) {
            return getService().getById(id);
        } else {
            return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public List<T> getAll() {
        return getService().getAll();
    }

    @PostMapping()
    public void add(@RequestBody T object) {
        getService().add(object);
    }

    @PutMapping()
    public Object update(@PathVariable ID id, @RequestBody T object) {
        if (getService().getById(id) != null) {
            return getService().update(object, id);
        } else {
            return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable(name = "id") ID id) {
        if (getService().getById(id) != null) {
            return getService().delete(id);
        } else {
            return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
        }
    }
}
