package cn.andios.kotlin.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

/*
    类似于catch运算符， onCompletion只会看到来自于Flow上游的异常，看不到Flow下游的异常
 */

private fun myMethod(): Flow<Int> = (1..5).asFlow()

// 这里除了onCompletion这个中间操作外，没有其他中间操作，只有一个collect终止操作
// collect这个终止操作是作为onCompletion的下游，即使collect执行完之后才会执行onCompletion操作
// 所以onCompletion是看不到下游(collect操作)的异常的
fun main() = runBlocking<Unit> {
    myMethod().onCompletion{cause -> println("flow completed with $cause") }
            .collect{value ->
                check(value <= 1) {
                    "collected $value"
                }
                println(value)
            }
}