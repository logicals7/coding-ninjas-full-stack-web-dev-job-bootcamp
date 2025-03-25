package com.Krishan.CodingNinjas.Coding.Ninjas.Application;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SimpleUserList implements UserList{
    ArrayList<User> listOfUsers;

    public SimpleUserList() {
        this.listOfUsers = new ArrayList<User>();
    }

    @Override
    public List<User> getUserList() {
        return this.listOfUsers;
    }

    @Override
    public void addUser(User user) {
        this.listOfUsers.add(user);
    }
}
