package cn.andios.kotlin.coroutine4

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-27
 */

// VM options加上参数：-Dkotlinx.coroutines.debug即可打印出协程的名字
private fun log(logMsg: String) = println("[${Thread.currentThread().name}] $logMsg")


// [main @coroutine#2] hello
// [main @coroutine#3] world
// [main @coroutine#1] the result is 30
fun main() = runBlocking<Unit> {
    val a = async {
        log("hello")
        10
    }

    val b = async {
        log("world")
        20
    }
    log("the result is ${a.await() + b.await()}")
}