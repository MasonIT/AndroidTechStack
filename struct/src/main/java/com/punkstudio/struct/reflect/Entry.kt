package com.punkstudio.struct.reflect

/**
 * Date:2021/1/15-2:05 PM
 * @author Mason
 */

fun main() {
    val clz = Class.forName("com.punkstudio.struct.reflect.Apple")
    val method = clz.getMethod("setPrice", Int::class.java)
    val appleInstance = clz.getConstructor().newInstance()
    val fields = clz.fields
    for (field in fields) {
        println("field is ${field.name}")
    }
    method.invoke(appleInstance, 5)
}