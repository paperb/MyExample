package com.example.example.container.collection.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedList_ {
    //LinkedList,也是不同步的，线程不安全
    //LinkedList不支持高效的随机访问，在指定位置插入和删除元素复杂度为O(n)，头尾为O(1)
    //底层是双向链表,内存占用更大，要保存直接后继和直接前驱和数据。
    List<Integer> linkedList = new LinkedList<>();

    public void testLinkedList(){
        linkedList.add(123);
        linkedList.add(123);
        linkedList.add(123);
        linkedList.add(123);
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        LinkedList_ linkedList_ = new LinkedList_();
        linkedList_.testLinkedList();
    }
}
