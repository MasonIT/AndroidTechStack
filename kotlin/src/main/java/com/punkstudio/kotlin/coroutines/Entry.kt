package com.punkstudio.kotlin.coroutines

import android.annotation.SuppressLint
import kotlinx.coroutines.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Date:2021/3/17-3:50 PM
 * @author Mason
 */

suspend fun main() {
//    println(1)
//    val job = GlobalScope.launch(start = CoroutineStart.UNDISPATCHED) {
//        println(2)
//        delay(100)
//        println(3)
//        println(coroutineContext[Job])
//    }
//    println(job)
//    job.cancel()
//    println(4)
//    job.join()
//    println(5)
//
//    val job1 = GlobalScope.launch(CoroutineName("hello") + Dispatchers.Main) {  }


    GlobalScope.launch(MyContinuationInterceptor()) {
        log(1)
        val job = async {
            log(2)
            delay(1000)
            log(3)
            "Hello"
        }
        log(4)
        job.await()
        log(5)
    }.join()
    log(6)
}


@SuppressLint("SimpleDateFormat")
suspend fun log(vararg text: Any) {
    println("[${SimpleDateFormat("HH:mm:ss:ms").format(Date(System.currentTimeMillis()))}], [${Thread.currentThread()}], " +
            text.contentToString())
}

