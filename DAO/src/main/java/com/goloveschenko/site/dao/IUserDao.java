package com.goloveschenko.site.dao;

import com.goloveschenko.site.entity.User;

import java.util.List;

public interface IUserDao {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
    User getUserById(long id);
    List<User> getUsers();
}
