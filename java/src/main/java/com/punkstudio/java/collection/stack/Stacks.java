package com.punkstudio.java.collection.stack;

import java.util.Stack;

/**
 * Date:2021/2/2-10:06 AM
 *
 * @author Mason
 */
public class Stacks {

    private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (String m : MONTHS) stack.push(m);
        System.out.println("stack =" + stack);
        stack.addElement("end line===========");
        System.out.println(stack.elementAt(5));
        System.out.println("popping element====");
        while (!stack.isEmpty()) System.out.println(stack.pop());
    }
}
