package com.epam.libranote.mapper;

import com.epam.libranote.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM \"USERS\"")
    List<User> findAllUsers();

    @Select("SELECT * FROM \"USERS\" u " +
            "JOIN \"USERS_HAS_BOOKS\" ub ON  " +
            "u.id = ub.user_id " +
            "JOIN \"BOOKS\" b ON " +
            "ub.book_id=b.id " +
            "WHERE u.id = (#{id})")
    User findUserWithBooks(@Param("id") Long id);


    @Insert("INSERT INTO \"USERS\" VALUES (#{login}) (#{password})")
        //TODO try to use user bean
    void insertUser(@Param("login") String login, @Param("password") String password);
}
