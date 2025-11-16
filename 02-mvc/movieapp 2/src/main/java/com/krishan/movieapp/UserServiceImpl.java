package com.krishan.movieapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepositoryImpl;

    @Override
    public User getUserById(int id) {
        return userRepositoryImpl.findUserById(id);
    }

    @Override
    public int registerUser(User user) {
         return userRepositoryImpl.saveUser(user);
    }
}
