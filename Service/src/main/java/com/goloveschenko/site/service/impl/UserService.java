package com.goloveschenko.site.service.impl;

import com.goloveschenko.site.dao.IUserDao;
import com.goloveschenko.site.entity.User;
import com.goloveschenko.site.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserDao userDao;

    @Autowired
    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addUser(User user) {
        userDao.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userDao.delete(id);
    }

    @Transactional
    public User getUserById(long id) {
        return userDao.findOne(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
