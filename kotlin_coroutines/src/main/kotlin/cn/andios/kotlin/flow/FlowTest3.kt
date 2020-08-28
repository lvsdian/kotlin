package cn.andios.kotlin.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// 协程完成类似的效果
//  1.不会阻塞主线程
//  2.计算结果会一次性返回给调用端

private suspend fun myMethod(): List<String> {
    delay(100)
    return listOf("111", "222", "333")
}

fun main() = runBlocking<Unit> {
    myMethod().forEach {
        println(it)
    }
}