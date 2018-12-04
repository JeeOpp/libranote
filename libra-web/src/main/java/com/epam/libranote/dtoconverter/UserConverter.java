package com.epam.libranote.dtoconverter;

import com.epam.libranote.dto.InsertUserDto;
import com.epam.libranote.dto.SimpleUserDto;
import com.epam.libranote.dto.UserIdDto;
import com.epam.libranote.dto.UserWithBooksDto;
import com.epam.libranote.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private ModelMapper modelMapper;

    @Autowired
    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User convertToEntity(InsertUserDto insertUserDto){
        return modelMapper.map(insertUserDto, User.class);
    }

    public User convertToEntity(SimpleUserDto simpleUserDto){
        return modelMapper.map(simpleUserDto, User.class);
    }

    public User convertToEntity(UserIdDto userIdDto){
        return modelMapper.map(userIdDto,User.class);
    }

    public SimpleUserDto convertToDto(User user){
        return modelMapper.map(user, SimpleUserDto.class);
    }

    public UserWithBooksDto convertToUserWithBooksDto(User user){
        return modelMapper.map(user, UserWithBooksDto.class);
    }
}
