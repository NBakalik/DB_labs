package com.bakalik.service;

import com.bakalik.repo.OrderRepository;
import com.bakalik.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderService extends GeneralService<Order, Integer> {
    @Autowired
    public OrderRepository orderRepository;

    @Override
    protected JpaRepository<Order, Integer> getRepo() {
        return orderRepository;
    }
}
