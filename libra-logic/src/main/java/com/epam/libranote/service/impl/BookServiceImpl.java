package com.epam.libranote.service.impl;

import com.epam.libranote.mapper.UserDao;
import com.epam.libranote.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private UserDao userDao;

    @Autowired
    public BookServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insert(BookService entity) {

    }

    @Override
    public List<BookService> findAll() {
        return null;
    }

    @Override
    public Optional<BookService> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(BookService entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
