package cn.andios.kotlin.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// 终止操作
// flow的终止操作都是挂起函数,终止操作才会真正的执行流的收集
// 1.toList与toSet
// 2.只获取第一个元素
// 3.reduce...

fun main() = runBlocking {
    val result = (1..3).asFlow()
        .map { it * it }
        .reduce { a, b -> a + b }
    println(result)
}