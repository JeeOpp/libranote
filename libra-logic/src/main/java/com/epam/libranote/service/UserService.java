package com.epam.libranote.service;

import com.epam.libranote.entity.Book;
import com.epam.libranote.entity.User;

public interface UserService extends BaseService<User> {
    void addBookInUserList(User user, Book book);
}
