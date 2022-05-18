package com.example.example.container.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//以无参数构造方法创建 ArrayList 时，实际上初始化赋值的是一个空数组。
// 当真正对数组进行添加元素操作时，才真正分配容量。即向数组中添加第一个元素时，数组容量扩为 10。
// ArrayList 每次扩容之后容量都会变为原来的 1.5 倍左右（oldCapacity 为偶数就是 1.5 倍，否则是 1.5 倍左右
public class ArrayList_ {
    //最常用的就这个ArrayList，适用于查找,插入删除元素的时间复杂度受元素位置的影响。
    //ArrayList底层是Object[]数组，线程不安全的
    //add方法默认加到列表尾部，复l杂度为O(1)，指定位置插入删除的复杂度为O(n-i)
    List<Integer> arrayList = new ArrayList<>();
    //储存的数据是有序的
    public void testArrayList(){
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);


        for (Integer integer : arrayList) {
            System.out.println(integer);
        }


    }

    public static void main(String[] args) {
        ArrayList_ arrayList = new ArrayList_();
        arrayList.testArrayList();//有序输出

    }
}
