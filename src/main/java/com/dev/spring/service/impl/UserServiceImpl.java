package com.dev.spring.service.impl;

import com.dev.spring.dao.UserDao;
import com.dev.spring.model.User;
import com.dev.spring.service.UserService;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
