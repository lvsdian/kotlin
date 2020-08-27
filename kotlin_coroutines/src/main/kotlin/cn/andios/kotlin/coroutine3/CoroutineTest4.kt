package cn.andios.kotlin.coroutine3

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * @author lvsdian
 * Created on 2020-08-27
 */
// 异步风格的函数
//
fun main() {
    val elapsedTime = measureTimeMillis {
        val value1 = intValue1Async()
        val value2 = intValue2Async()

        runBlocking {
            println("val1:${value1.await()}")
            println("val2:${value2.await()}")
        }
    }
    // 3000+
    println("total:$elapsedTime")
}


private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}

fun intValue1Async() = GlobalScope.async {
    intValue1()
}

fun intValue2Async() = GlobalScope.async {
    intValue2()
}