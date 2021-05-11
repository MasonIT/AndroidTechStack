package com.punkstudio.java.collection.list;

import java.util.LinkedList;

/**
 * Date:2021/1/26-11:06 AM
 *
 * @author Mason
 */
public class QueueTest {
    final LinkedList<String> linkedList = new LinkedList<>();

    // 放入
    public void put(String str){
        linkedList.addFirst(str);
    }

    // 获取
    public String get(){
        return linkedList.removeLast();
    }

    // 判断是否为空
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
}
