package com.bakalik.service;

import com.bakalik.repo.UserRepository;
import com.bakalik.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService extends GeneralService<User, Integer> {
    @Autowired
    public UserRepository userRepository;

    @Override
    protected JpaRepository<User, Integer> getRepo() {
        return userRepository;
    }
}
