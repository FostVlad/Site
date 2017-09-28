package com.goloveschenko.site.dao;

import com.goloveschenko.site.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Long> {
}
