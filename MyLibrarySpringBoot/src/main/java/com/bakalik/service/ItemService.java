package com.bakalik.service;

import com.bakalik.repo.ItemRepository;
import com.bakalik.domain.Item;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ItemService extends GeneralService<Item, Integer> {
    @Autowired
    public ItemRepository itemRepository;

    @Override
    protected JpaRepository<Item, Integer> getRepo() {
        return itemRepository;
    }
}
