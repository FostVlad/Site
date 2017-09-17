package com.goloveschenko.site.dao.impl;

import com.goloveschenko.site.dao.IUserDao;
import com.goloveschenko.site.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements IUserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void deleteUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        if (user != null) {
            session.delete(user);
        }

    }
    public User getUserById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        return (List<User>) session.createCriteria(User.class).list();
//        return (List<User>) session.createQuery("from User").list();
    }
}