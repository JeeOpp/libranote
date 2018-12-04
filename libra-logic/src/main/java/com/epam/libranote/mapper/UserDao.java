package com.epam.libranote.mapper;

import com.epam.libranote.entity.Book;
import com.epam.libranote.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserDao {

    List<User> findAllUsers();

    User findUserWithBooks(Long id);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    void addBookInUserList(@Param("user") User user, @Param("book") Book book);

}
