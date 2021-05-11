package com.punkstudio.struct.reflect;

/**
 * Date:2021/1/15-2:04 PM
 *
 * @author Mason
 */
public class Apple {

    private int price;

    public String name;

    public Double brand;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        System.out.println("price is " + price);
        this.price = price;
    }
}
