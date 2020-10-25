package cn.andios.kotlin.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

// try catch捕获元素发射阶段的异常
private fun myMethod(): Flow<String> =
        flow {
            for (i in 1..3) {
                println("emitting $i")
                emit(i)
            }
        }.map {value ->
            check (value <= 1) {
                "crash on $value"
            }
            "string $value"
        }

fun main() = runBlocking<Unit> {
    try {
        myMethod().collect{
            println(it)
        }
    } catch (e: Throwable) {
        println("caught $e")
    }
}