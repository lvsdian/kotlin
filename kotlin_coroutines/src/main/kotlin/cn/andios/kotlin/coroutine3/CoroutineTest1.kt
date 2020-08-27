package cn.andios.kotlin.coroutine3

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * @author lvsdian
 * Created on 2020-08-26
 */

// 挂起函数的组合

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = intValue1()
        val value2 = intValue2()
        println("$value1 + $value2 = ${value1 + value2}")
    }
    // 3000+，因为上述两个方法串行执行
    println("total:$elapsedTime")

}



private suspend fun intValue1(): Int {
    delay(1000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(2000)
    return 20
}