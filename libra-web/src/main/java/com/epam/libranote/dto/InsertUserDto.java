package com.epam.libranote.dto;

import com.epam.libranote.entity.Book;
import lombok.Data;

@Data
public class InsertUserDto {
    private String login;
    private String password;
}
