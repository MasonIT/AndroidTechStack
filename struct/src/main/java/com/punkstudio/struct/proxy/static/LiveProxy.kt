package com.punkstudio.struct.proxy.static

/**
 * Date:2021/1/13-2:05 PM
 * @author Mason
 */
class LiveProxy(private val live: ILive) : ILive {

    override fun eat() {
        println("You should wash your hand before eat")
        live.eat()
    }

    override fun sleep() {
        println("You should wash your feet before go to bed")
        live.sleep()
    }
}