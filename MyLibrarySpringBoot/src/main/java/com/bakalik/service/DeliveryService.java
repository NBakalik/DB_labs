package com.bakalik.service;

import com.bakalik.repo.DeliveryRepository;
import com.bakalik.domain.Delivery;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeliveryService extends GeneralService<Delivery, Integer> {
    @Autowired
    public DeliveryRepository deliveryRepository;

    @Override
    protected JpaRepository<Delivery, Integer> getRepo() {
        return deliveryRepository;
    }
}
