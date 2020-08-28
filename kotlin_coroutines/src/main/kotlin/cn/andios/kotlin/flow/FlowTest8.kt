package cn.andios.kotlin.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// Flow的中间运算符
// Flow的中间运算符的思想与java stream完全一致
// Flow与Sequence之间在中间运算符上的重要差别在于：对于Flow来说，这些中间运算符内的代码块是可以调用挂起函数的

private suspend fun myExecution(input: Int): String {
    delay(1000)
    return "output：$input"
}

fun main() = runBlocking {
    (1..5).asFlow()
        .map { input -> myExecution(input) }
        .collect { println(it) }
}