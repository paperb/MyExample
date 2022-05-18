package com.example.auth.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class User {
    private Long id;

    private String username;
    private String password;
    private Date birthday;
    private Integer gender;

}
