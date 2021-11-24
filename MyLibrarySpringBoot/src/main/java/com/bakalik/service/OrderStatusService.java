package com.bakalik.service;

import com.bakalik.repo.OrderStatusRepository;
import com.bakalik.domain.OrderStatus;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderStatusService extends GeneralService<OrderStatus, Integer> {
    @Autowired
    public OrderStatusRepository orderStatusRepository;

    @Override
    protected JpaRepository<OrderStatus, Integer> getRepo() {
        return orderStatusRepository;
    }
}
