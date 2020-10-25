package cn.andios.kotlin.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    Buffer(缓冲)
    如果让一个flow，它的不同部分执行在不同协程中，从系统角度来看，会减少运行时间
 */

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        // 模拟一个极为耗时的操作，该操作之后才开始流元素的发射
        delay(100)
        emit(i)
    }
}

fun main = runBlocking<Unit> {
    val time = measureTimeMillis {
        myMethod().collect{value ->
            delay(200)
            println(value)
        }
    }
    println(time)
}