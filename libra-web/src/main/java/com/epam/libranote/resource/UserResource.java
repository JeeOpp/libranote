package com.epam.libranote.resource;

import com.epam.libranote.entity.User;
import com.epam.libranote.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserMapper userMapper;

    @Autowired
    public UserResource(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/all")
    public List<User> getAll(){
        List<User> user = userMapper.findAllUsers();
        System.out.println(user.toString());
        return user;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        User user = userMapper.findUserWithBooks(id);
        System.out.println(user);
        return user;
    }
}
