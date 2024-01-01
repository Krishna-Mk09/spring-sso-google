package com.solix.jdp.springssogoogle.service;

import com.solix.jdp.springssogoogle.domain.User;
import com.solix.jdp.springssogoogle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }
}
