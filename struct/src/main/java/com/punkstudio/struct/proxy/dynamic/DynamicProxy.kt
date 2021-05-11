package com.punkstudio.struct.proxy.dynamic

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * Date:2021/1/13-2:14 PM
 * @author Mason
 */
class DynamicProxy : InvocationHandler {

    private var obj: Any? = null

    fun create(obj: Any): Any {
        this.obj = obj
        return Proxy.newProxyInstance(obj.javaClass.classLoader, obj.javaClass.interfaces, this)
    }

    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        println("Please write corresponding docs before working")
        method?.invoke(obj, *(args ?: arrayOfNulls<Any>(0)))
        return null
    }
}