package com.example.example.container.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*HashMap的扩容机制：
* 链表大小大于默认阈值8时，调用treeifyBin(),决定是否转化成红黑树，
* 在当前数组长度小于64时，会优先进行数组扩容，
*loadFactor加载因子，loadFactor越接近1，数组中存放的entry越多，链表长度增加，loadFactor越趋于0
* 数值中存放的entry越少，链表越短
*
*
* */
public class HashMap_ {
    //HashMap底层是数组+链表+红黑树，默认初始容量为16，每次扩容变成2倍，如果给定了容量初始值，那么hashmap会将其扩充为2的幂次方大小
    //线程不安全
    public void putValue(Map<Integer,String> hashMap){
        hashMap.put(1,"一");
        hashMap.put(2,"二");
        hashMap.put(3,"三");
        hashMap.put(4,"四");
        hashMap.put(5,"五");
    }

    //迭代器遍历集合,迭代器只能迭代Collect下的集合，所以用map.entrySet()返回一个set是Map<k,v>类型的
    public void testIterator(Map<Integer,String> hashMap){

        for (Map.Entry<Integer, String> next : hashMap.entrySet()) {
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }

    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();


        HashMap_ hashMap_ = new HashMap_();
        hashMap_.putValue(map);
        hashMap_.testIterator(map);
    }

}
