package com.punkstudio.struct.proxy

import com.punkstudio.struct.proxy.dynamic.*
import com.punkstudio.struct.proxy.static.Live
import com.punkstudio.struct.proxy.static.LiveProxy

/**
 * Date:2021/1/13-2:10 PM
 * @author Mason
 */

fun main() {
//    val live = LiveProxy(Live())
//    live.eat()
//    live.sleep()
    val developerProxy = DynamicProxy().create(Developer()) as IDeveloper
    val testerProxy = DynamicProxy().create(Tester()) as ITester
    developerProxy.writeCode()
    testerProxy.test()
}