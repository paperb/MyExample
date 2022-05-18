package com.example.example.exceptionanderror;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception0 {
    //Exception:程序本身可以处理的异常。可以catch来捕获

    //分为unchecked Exception(不受检查异常),编译期间无法检查
    //RuntimeException 及其子类都统称为非受检查异常，
    // 例如：NullPointerException、
    // NumberFormatException（字符串转换为数字）、
    // ArrayIndexOutOfBoundsException（数组越界）、
    // ClassCastException（类型转换错误）、
    // ArithmeticException（算术错误）等


    // checked Exception(受检查异常)，编译期间检查，
    //除了RuntimeException及其子类以外，其他的Exception类及其子类都属于受检查异常

    String fileName = "file does not exist";
    File file = new File(fileName);
    FileInputStream fileInputStream = new FileInputStream(file);
    //此处的FileNotFoundException就为checkedExcption
    public Exception0() throws FileNotFoundException {
    }
}
