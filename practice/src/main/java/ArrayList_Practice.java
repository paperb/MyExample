import jdk.nashorn.api.scripting.ClassFilter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class ArrayList_Practice {
    int steps=0;
    int upperCount = 0;
    int lowerCount = 0;
    int numCount = 0;

    public List<?> initArrayList() {//泛型，类型参数化
        List<Object> arrayList = new ArrayList<>();
        List<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        char[] c = new String("123").toCharArray();


        for (char c1 : c) {
            if (Character.isUpperCase(c1)) {
                upperCount += 1;
            }
            if (Character.isLowerCase(c1)) {
                lowerCount += 1;
            }
            if (Character.isDigit(c1)) {
                numCount += 1;
            }
        }
        System.out.println(c.length + "okokokokok");
        arrayList.add("First:Data");
        arrayList.add(0, "Fourth:Data");
        arrayList.addAll(list);
        arrayList.addAll(4, list);
        return arrayList;
    }

    public Object testArrayList(List<?> list) {
        boolean empty = list.isEmpty();
        return empty;
    }

    public static void main(String[] args) {
        ArrayList_Practice arrayList_practice = new ArrayList_Practice();
        List<?> objects = arrayList_practice.initArrayList();

        //通过流遍历List每一个元素封装为一个Map
        //使用了lambda表达式
        List<Object> hashmap = objects.stream().map(o -> {
            HashMap<Object, Object> map = new HashMap<>();
            map.put("hashmap", o);
            return map;
        }).collect(Collectors.toList());
        System.out.println(hashmap);
        System.out.println("======================");
        //使用流的迭代器遍历
        Iterator<?> iterator1 = objects.stream().iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            System.out.println(next);
        }
        System.out.println("======================" + "流的迭代器遍历");
        System.out.println(objects.hashCode());
        System.out.println("======================");
        //使用迭代器遍历
        Iterator<?> iterator = objects.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("======================");
        //增强for遍历
        for (Object o : objects) {
            System.out.println(o);
        }

    }

}
