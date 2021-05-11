package com.punkstudio.java.collection.lock;

/**
 * Date:2021/5/10-5:10 PM
 *
 * @author Mason
 */
public class TestEntry {

    public static synchronized void test1() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {

                }
            }
    }

    public static synchronized void test2() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {

                }
            }
    }

    public static void main(String[] args) {
        final TestEntry testEntry1 = new TestEntry();
        final TestEntry testEntry2 = new TestEntry();

        Thread test1 = new Thread(new Runnable() {
            public void run() {
                TestEntry.test1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                TestEntry.test2();
            }
        }, "test2");
        test1.start();
        test2.start();
    }
}
