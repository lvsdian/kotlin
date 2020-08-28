package cn.andios.kotlin.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// Flow context
// Flow的收集动作总是发生在调用协程的上下文当中,这个特性叫做Context Preservation(上下文保留)

private fun log(msg: String) = println("[${Thread.currentThread().name}], $msg")

private fun myMethod(): Flow<Int> = flow {
    log("started")

    for (i in 1..3) {
        emit(i)
    }
}

fun main() = runBlocking {
    myMethod().collect {
        log("collected $it")
    }
}