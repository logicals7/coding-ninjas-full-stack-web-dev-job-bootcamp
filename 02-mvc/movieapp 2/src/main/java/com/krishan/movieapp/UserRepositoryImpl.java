package com.krishan.movieapp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public int saveUser(User user) {
        int id = users.size()+1;
        user.setId(id);
        users.add(user);
        System.out.println("Saved User: " + user);
        return id;
    }

    @Override
    public User findUserById(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
