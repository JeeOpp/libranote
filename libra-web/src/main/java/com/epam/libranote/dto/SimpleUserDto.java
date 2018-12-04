package com.epam.libranote.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class SimpleUserDto {
    private Long id;
    private String login;
    private String password;
}
