package com.epam.libranote.dtoconverter;

import com.epam.libranote.dto.BookIdDto;
import com.epam.libranote.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {
    private ModelMapper modelMapper;

    @Autowired
    public BookConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    Book convertDtoToEntity(BookIdDto bookIdDto){
        return modelMapper.map(bookIdDto, Book.class);
    }
}
