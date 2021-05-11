package com.punkstudio.struct.proxy.static

/**
 * Date:2021/1/13-2:08 PM
 * @author Mason
 */
class Live : ILive {

    override fun eat() {
        println("I'm gonna eat")
    }

    override fun sleep() {
        println("I'm gonna go to bed")
    }
}