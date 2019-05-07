package com.example.demo.mapper;


import com.example.demo.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository("UserMapper")
public interface UserMapper {

    @Select("select * from user where name=#{name}")
    public User getUserByName(String name);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(id,name,password,role) values(#{id},#{name},#{password},#{role})")
    public int insertUser(User user);
}
