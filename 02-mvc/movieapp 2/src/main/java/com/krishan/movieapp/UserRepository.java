package com.krishan.movieapp;

public interface UserRepository {
    public int saveUser(User user);

    public User findUserById(int id);
}
