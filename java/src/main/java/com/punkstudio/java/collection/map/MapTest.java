package com.punkstudio.java.collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {

    public static void main(String[] args) {

        HashMap<Person, String> map = new HashMap<Person, String>();
        map.put(new Person(18, "Mason"), "C++");
        map.put(new Person(19, "Chris"), "C");
        map.put(new Person(20, "John"), "PHP");
        map.put(new Person(18, "Mason"), "Flutter");
        map.put(new Person(18, "Zero"), "Android");

        Set<Map.Entry<Person, String>> set = map.entrySet();
        for (Map.Entry<Person, String> entry : set) {
            System.out.println("entry=== key=" + entry.getKey() + ", value=" + entry.getValue());
        }

        System.out.println("=======================================");

        LinkedHashMap<Person, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(new Person(18, "Mason"), "C++");
        linkedHashMap.put(new Person(19, "Chris"), "C");
        linkedHashMap.put(new Person(20, "John"), "PHP");
        linkedHashMap.put(new Person(18, "Mason"), "Flutter");
        linkedHashMap.put(new Person(18, "Zero"), "Android");

        for (Map.Entry<Person, String> entry : linkedHashMap.entrySet()) {
            System.out.println("entry=== key=" + entry.getKey() + ", value=" + entry.getValue());
        }

        System.out.println("=======================================");

        TreeMap<Person, String> treeMap = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.getAge() - o2.getAge();
                if (result == 0) {
                    return o1.getName().compareTo(o2.getName());
                }
                return result;
            }
        });

        treeMap.put(new Person(18, "Mason"), "C++");
        treeMap.put(new Person(19, "Chris"), "C");
        treeMap.put(new Person(20, "John"), "PHP");
        treeMap.put(new Person(18, "Mason"), "Flutter");
        treeMap.put(new Person(18, "Zero"), "Android");
        for (Map.Entry<Person, String> entry : treeMap.entrySet()) {
            System.out.println("entry=== key=" + entry.getKey() + ", value=" + entry.getValue());
        }

        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("first", "linlin");
        testMap.put("second", "好好学java");
        testMap.put("third", "sihai");
        testMap.put("first", "sihai2");


        // 第一种：通过Map.keySet遍历key和value
        System.out.println("===================通过Map.keySet遍历key和value:===================");
        for (String key : testMap.keySet()) {
            System.out.println("key= " + key + "  and  value= " + testMap.get(key));
        }

        // 第二种：通过Map.entrySet使用iterator遍历key和value
        System.out.println("===================通过Map.entrySet使用iterator遍历key和value:===================");
        Iterator<Map.Entry<String, String>> it = testMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + "  and  value= "
                    + entry.getValue());
        }

        // 第三种：通过Map.entrySet遍历key和value
        System.out.println("===================通过Map.entrySet遍历key和value:===================");
        for (Map.Entry<String, String> entry : testMap.entrySet()) {
            System.out.println("key= " + entry.getKey() + "  and  value= "
                    + entry.getValue());
        }

        // 第四种：通过Map.values()遍历所有的value，但是不能遍历键key
        System.out.println("===================通过Map.values()遍历所有的value:===================");
        for (String v : testMap.values()) {
            System.out.println("value= " + v);
        }
    }
}