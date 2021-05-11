package com.punkstudio.java.collection.list;

import java.util.LinkedList;

/**
 * Date:2021/1/26-10:56 AM
 *
 * @author Mason
 */
public class StackTest {

    private final LinkedList<String> linkedList = new LinkedList<>();

    public String pop() {
        return linkedList.removeFirst();
    }

    public void push(String e) {
        linkedList.addFirst(e);
    }

    public String peek() {
        return linkedList.peek();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
