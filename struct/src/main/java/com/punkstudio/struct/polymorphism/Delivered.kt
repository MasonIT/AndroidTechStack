package com.punkstudio.struct.polymorphism

/**
 * Date:2021/1/14-10:50 AM
 * @author Mason
 */
open class Delivered : Base(), IType{

    override fun m1() {
        println("Delivered m1")
    }

    override fun m3() {
        println("Delivered m3")
    }
}