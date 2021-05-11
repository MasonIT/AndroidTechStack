package com.punkstudio.java.collection.set;

import java.util.Objects;

/**
 * Date:2021/1/26-3:21 PM
 *
 * @author Mason
 */
public class Person1 implements Comparable<Person1> {
    private int age;
    private String name;

    public Person1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person1 = (Person1) o;
        return age == person1.age &&
                name.equals(person1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public int compareTo(Person1 o) {
        int result = this.age - o.age;
        if (result == 0) {
            return this.name.compareTo(o.name);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
