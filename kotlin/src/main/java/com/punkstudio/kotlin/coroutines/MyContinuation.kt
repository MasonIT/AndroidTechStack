package com.punkstudio.kotlin.coroutines

import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

/**
 * Date:2021/3/18-4:52 PM
 * @author Mason
 */
class MyContinuationInterceptor : ContinuationInterceptor {

    override val key: CoroutineContext.Key<*>
        get() = ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> = MyContinuation(continuation)
}

class MyContinuation<T>(private val continuation: Continuation<T>)  : Continuation<T> {
    override val context: CoroutineContext
        get() = continuation.context

    override fun resumeWith(result: Result<T>) {
        println("MyContinuation: $result")
        continuation.resumeWith(result)
    }

}

