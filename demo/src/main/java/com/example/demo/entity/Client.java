package com.example.demo.entity;

import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class Client implements Serializable {

    @NotEmpty
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;
    @NotNull
    private Date createTime;

}
