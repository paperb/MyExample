package com.example.example.container.map;

public class ConcurrentHashMap_ {

    //ConcurrentHashmap在1.8之前是分段的数组+链表，1.8后数据结构和hashmap结构一样
    //1.7对数组进行了Segment（分割分段）每把锁只锁容器中一部分数据，1.8直接使用了Node数组+链表+红黑树，
    // 并发使用synchronized和CAS，synchronized 只锁定当前链表或红黑二叉树的首节点，这样只要 hash 不冲突，就不会产生并发
    public static void main(String[] args) {

    }
}
