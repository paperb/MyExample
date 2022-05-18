package com.example.example.basicDataType;

import io.lettuce.core.StrAlgoArgs;

public class BasicDataType {
    int i = 0;//2^32
    short s = 1;//2^16
    long l = 0L;//2^64,long和Long后面要加L否则作为整形解析。
    byte b = 127;//2^8

    char c = 16;//2^16,非负
    char c1 = 'a';//单引号
    float f = 32154324234543.24134234235f;//2^32
    double d = 63434563456546.6574657657d;//2^64



    boolean t = true;
    boolean fa = false;
//===============================================
    //Byte,Short,Integer,Long 这 4 种包装类默认创建了数值 [-128，127] 的相应类型的缓存数据
    //Character 创建了数值在 [0,127] 范围的缓存数据，Boolean 直接返回 True or False
    Integer in1 = 123;
    Short sh1 = 123;
    Long long1 = 123L;
    Byte by1 = 127;

    String string = "123";
    Float flo1 = 123123f;
    Double dou1 = 1234.34545645745657d;

    Boolean bool1 = true;


    public static void main(String[] args) {
        BasicDataType basic = new BasicDataType();
        System.out.println();
    }

}
