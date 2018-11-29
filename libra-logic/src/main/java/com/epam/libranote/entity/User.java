package com.epam.libranote.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Long id;
    private String login;
    private String password;

    private List<Book> bookList;
}
