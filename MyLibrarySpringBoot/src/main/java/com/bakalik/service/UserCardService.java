package com.bakalik.service;

import com.bakalik.repo.UserCardRepository;
import com.bakalik.domain.UserCard;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserCardService extends GeneralService<UserCard, Integer> {
    @Autowired
    public UserCardRepository userCardRepository;

    @Override
    protected JpaRepository<UserCard, Integer> getRepo() {
        return userCardRepository;
    }
}
