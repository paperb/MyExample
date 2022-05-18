package com.example.example.java3Features;


//父类
public class Parent {
    public String my_method(){
        return "这是父类的方法";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }
    public Integer age = 20;
    private String name = "david";
    private String sex = "f";


}
