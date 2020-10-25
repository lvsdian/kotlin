package cn.andios.kotlin.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/*
    flatten flow，打平
    Flow<Flow<Int>> -> Flow<Int>
 */

private fun myMethod(i: Int): Flow<String> = flow {
    emit("$i: first")
    delay(500)
    emit("$i: second")
}

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis();

    (1..2).asFlow().onEach{delay(100)}
            .flatMapConcat{ myMethod(it)}
            .collect {value ->
                println("$value at ${System.currentTimeMillis() - startTime} ms")
            }
}