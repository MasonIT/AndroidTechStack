package com.punkstudio.struct.polymorphism

/**
 * Date:2021/1/14-10:50 AM
 * @author Mason
 */
class Delivered2 : Delivered(){

    override fun m2() {
        println("Delivered2 m2")
    }

    fun m4() {
        println("Delivered2 m4")
    }
}