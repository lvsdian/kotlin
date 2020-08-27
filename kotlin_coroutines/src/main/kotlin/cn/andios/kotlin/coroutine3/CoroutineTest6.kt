package cn.andios.kotlin.coroutine3

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * @author lvsdian
 * Created on 2020-08-27
 */
// 关于父子协程的异常与取消问题
// 协程的取消总是会沿着的层次体系向上进行传播

fun main() = runBlocking<Unit> {
    // value2 throws an exception --> value1 was cancelled --> computation failed
    try {
        failureComputation()
    } finally {
        println("computation failed")
    }
}

private suspend fun failureComputation(): Int = coroutineScope {
    val value1 = async<Int> {
        try {
            delay(999999)
            50
        } finally {
            println("value1 was cancelled")
        }
    }
    val value2 = async<Int> {
        Thread.sleep(2000)
        println("value2 throws an exception")
        throw Exception()
    }
    value1.await() + value2.await()
}