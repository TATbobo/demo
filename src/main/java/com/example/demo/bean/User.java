package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.annotations.Select;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private String password;
    private String role;
}
