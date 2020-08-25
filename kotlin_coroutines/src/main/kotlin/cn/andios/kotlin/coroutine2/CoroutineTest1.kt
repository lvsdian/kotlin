package cn.andios.kotlin.coroutine2

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CancellationException

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

// 协程的取消与超时

fun main() = runBlocking {
    val myJob = GlobalScope.launch {
        repeat(10) {
            println("wc:$it")
            // dela()实现会判断isActive，所以协程会被取消
            delay(200)
        }
    }
    delay(1000)
    println("hello")

    myJob.cancel(CancellationException("over"))
    myJob.join()

    println("well")
}