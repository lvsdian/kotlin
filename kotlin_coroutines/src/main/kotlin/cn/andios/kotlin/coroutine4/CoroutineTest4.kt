package cn.andios.kotlin.coroutine4

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * @author lvsdian
 * Created on 2020-08-27
 */

private fun log(logMsg: String) = println("[${Thread.currentThread().name}] $logMsg")

// 如下，会生成两个线程来执行，每个线程又会生成一个协程
fun main() {
    newSingleThreadContext("Context1").use { ctx1 ->
        newSingleThreadContext("Context2").use { ctx2 ->
            runBlocking(context = ctx1) {
                // [Context1 @coroutine#1] started in Context1
                log("started in Context1")
                withContext(ctx2) {
                    // [Context2 @coroutine#1] Working in Context2
                    log("Working in Context2")
                }
                // [Context1 @coroutine#1] Back to Context1
                log("Back to Context1")
            }
        }
    }
}