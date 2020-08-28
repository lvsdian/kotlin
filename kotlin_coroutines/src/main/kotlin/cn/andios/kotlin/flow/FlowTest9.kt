package cn.andios.kotlin.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// transfer

private suspend fun myExecution(input: Int): String {
    delay(1000)
    return "output：$input"
}

fun main() = runBlocking {
    (1..3).asFlow()
        .transform {
            input ->
            emit("my input：$input")
            emit(myExecution(input))
            emit("wc")
        }.collect { println(it) }
}