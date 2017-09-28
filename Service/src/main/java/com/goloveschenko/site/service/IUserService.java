package com.goloveschenko.site.service;

import com.goloveschenko.site.entity.User;

import java.util.List;

public interface IUserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
    User getUserById(long id);
    List<User> getAllUsers();
}
