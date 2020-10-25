package cn.andios.kotlin.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*
    flow exception
 */

private fun myMethod(): Flow<Int> = flow {
    for (i in 1.. 3) {
        println("emitting $i")
        emit(i)
    }
}

// 符合check的判断条件，就会抛异常，由catch捕获，并且check块中的内容会作为异常信息的一部分
// 这里是在collect中出现异常，即终止操作阶段出现异常
fun main() = runBlocking<Unit> {
    try {
        myMethod().collect{value ->
            println(value)
            check(value <= 1) {
                "collected $value"
            }
        }
    } catch (e: Throwable) {
        println("caught $e")
    }
}