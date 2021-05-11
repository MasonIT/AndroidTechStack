package com.punkstudio.java.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Date:2021/1/26-4:14 PM
 *
 * @author Mason
 */
public class SetTest {

    public static void main(String[] args) {
        TreeSet<Person1> treeSet = new TreeSet<Person1>();
        treeSet.add(new Person1(18, "Mason"));
        treeSet.add(new Person1(19, "Chris"));
        treeSet.add(new Person1(20, "John"));
        treeSet.add(new Person1(18, "Zero"));
        treeSet.add(new Person1(18, "Mason"));

        for (Person1 p : treeSet) {
            System.out.println(p.toString());
        }
        TreeSet<Person2> treeSet2 = new TreeSet<Person2>(new Comparator<Person2>() {
            @Override
            public int compare(Person2 o1, Person2 o2) {
                int result = o1.getAge() - o2.getAge();
                if (result == 0) {
                    return o1.getName().compareTo(o2.getName());
                }
                return result;
            }
        });
        treeSet2.add(new Person2(18, "Mason"));
        treeSet2.add(new Person2(19, "Chris"));
        treeSet2.add(new Person2(20, "John"));
        treeSet2.add(new Person2(18, "Zero"));
        treeSet2.add(new Person2(18, "Mason"));
        for (Person2 p : treeSet2) {
            System.out.println(p.toString());
        }
    }
}
