package com.epam.libranote.resource;

import com.epam.libranote.dto.InsertUserDto;
import com.epam.libranote.dto.SimpleUserDto;
import com.epam.libranote.dto.UserIdDto;
import com.epam.libranote.dto.UserWithBooksDto;
import com.epam.libranote.dtoconverter.UserConverter;
import com.epam.libranote.entity.Book;
import com.epam.libranote.entity.User;
import com.epam.libranote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserConverter userConverter;

    private UserService userService;

    private User currentUser; //TODO current user

    @Autowired
    public UserResource(UserConverter userConverter, UserService userService) {
        this.userConverter = userConverter;
        this.userService = userService;
    }

    @PostMapping("/")
    public void insertUser(@PathVariable SimpleUserDto simpleUserDto){
        User user = userConverter.convertToEntity(simpleUserDto);
        userService.insert(user);
    }

    @GetMapping
    public List<SimpleUserDto> getAll(){
        List<User> user = userService.findAll();

        System.out.println(user.toString());

        return user.stream()
                .map(this.userConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserWithBooksDto getUserById(@PathVariable Long id) throws Exception{
        Optional<User> user = userService.findById(id);
        return userConverter.convertToUserWithBooksDto(
                user.orElseThrow(Exception::new)     //TODO exception
        );
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestParam SimpleUserDto simpleUserDto){
        User user = userConverter.convertToEntity(simpleUserDto);
        userService.update(user);
    }

    @PostMapping("/users/{id}/books")
    public void addBookInUserList(@RequestParam Book book) throws Exception{
        userService.addBookInUserList(currentUser, book);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id, @RequestParam UserIdDto userIdDto) {
        User user = userConverter.convertToEntity(userIdDto);
        userService.deleteById(user.getId());
    }
}
