package com.epam.libranote.entity;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String name;
    private String author;

    private boolean isRead;
    private boolean isFavourite;
    private boolean isDeleted;
}
