package cn.andios.kotlin.coroutine4

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */
// CoroutineName上下文元素可以让我们对协程进行命名，以便能够输出可读性较好的日志信息

private fun log(logMsg: String) = println("[${Thread.currentThread().name}] $logMsg")

fun main() = runBlocking<Unit>(CoroutineName("wc")) {
    log("hello")

    val value1 = async (CoroutineName("coroutine1")) {
        delay(100)
        log("coroutine1 log")
        10
    }
    val value2 = async(CoroutineName("coroutine2")) {
        delay(1000)
        log("coroutine2 log")
        20
    }
    log("result:${value1.await() + value2.await()}")
}