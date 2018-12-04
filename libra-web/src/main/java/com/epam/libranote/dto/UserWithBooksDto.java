package com.epam.libranote.dto;

import com.epam.libranote.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class UserWithBooksDto {
    private Long id;
    private String login;
    private String password;

    private List<Book> bookList;
}
