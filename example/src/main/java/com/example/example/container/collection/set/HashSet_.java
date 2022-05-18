package com.example.example.container.collection.set;

import org.springframework.data.relational.core.sql.In;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class HashSet_ {
    //HashSet,是基于HashMap实现的，
    //无序，且唯一，基于红黑树
    //检查重复是通过计算hashcode()判断对象加入的位置，同时与其他对象加入的位置比较，如果没有重复的hashcode
    //hashset会假设对象没有重复出现，如果有相同的hashcode出现，这时候会调用equals方法比较两个对象是否真的相同
    //如果两者相同，HashSet就不会让加入操作成功
    Set<Integer> hashSet = new HashSet<>();

    public void testHashSet(){


    }


}
