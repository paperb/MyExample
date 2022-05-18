package com.example.example.generic;

import java.util.ArrayList;
import java.util.List;

//泛型
public class Generic {
    List<String> l1 = new ArrayList<String>();

    List<Integer> l2 = new ArrayList<Integer>();

    public void compareList() {
        System.out.println(l1.getClass() == l2.getClass());
    }

    //泛型还有一种较为准确的说法就是为了参数化类型，或者说可以将类型当作参数传递给一个类或者是方法
    public class Cache<T> {
        T value;

        public Object getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

    }
    //List中的泛型类型在jvm运行时被擦除，变成Object，所以比较两个List为true
    public static void main(String[] args) {
        Generic generic = new Generic();
        generic.compareList();//true
        //==============================================================

        //泛型参数化，在编译期就确定了类型，和强制转换相比好，是一种类型安全检测机制
        Cache<String> cache1 = generic.new Cache<String>();
        cache1.setValue("123");
        Object value = cache1.getValue();
        System.out.println(value.getClass());

        Cache<Integer> cache2 = generic.new Cache<Integer>();
        cache2.setValue(456);
        Object value1 = cache2.getValue();
        System.out.println(value1.getClass());


    }
}
