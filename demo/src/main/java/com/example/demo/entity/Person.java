package com.example.demo.entity;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

@Data
public class Person {

     @Field
     private Integer id;
     private String name;
     private Integer age;
     private String password;

     private boolean changed;

}
