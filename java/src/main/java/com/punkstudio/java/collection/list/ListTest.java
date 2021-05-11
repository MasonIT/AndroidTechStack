package com.punkstudio.java.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Date:2021/1/26-4:12 PM
 *
 * @author Mason
 */
public class ListTest {
    public static void main(String[] args) {
        String a = new String("2") + new String("3");
        System.out.println(a == a.intern());
        System.out.println(a == "23");


        String f = "abc";
        String e = new String("abc");
        System.out.println(f == e);
        System.out.println(f.equals(e));


        String j = "45";
        String k = new String("4") + new String("5");
        System.out.println(k == k.intern());
        System.out.println(k == "45");

        StackTest stackTest = new StackTest();
        stackTest.push("1");
        stackTest.push("2");
        stackTest.push("3");
        stackTest.push("4");
        stackTest.push("5");

        while (!stackTest.isEmpty()) {
            System.out.println(stackTest.pop());
        }

        Collection<String> rawCollection = new ArrayList<String>();
        Collection<String> insertCollection = new ArrayList<String>();
        insertCollection.add("John");
        System.out.println(rawCollection.add("Mason"));
        System.out.println(rawCollection.add("Christina"));
        System.out.println(rawCollection.addAll(rawCollection));
        System.out.println(rawCollection.addAll(insertCollection));

        Iterator it = rawCollection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
