package com.epam.libranote.service.impl;

import com.epam.libranote.entity.Book;
import com.epam.libranote.entity.User;
import com.epam.libranote.mapper.UserDao;
import com.epam.libranote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;


    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insert(User user) {
        userDao.insertUser(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAllUsers();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(
                userDao.findUserWithBooks(id)
        );
    }

    @Override
    public void addBookInUserList(User user, Book book) {
        userDao.addBookInUserList(user, book);
    }

    @Override
    public void update(User entity) {
        userDao.updateUser(entity);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteUserById(id);
    }
}
