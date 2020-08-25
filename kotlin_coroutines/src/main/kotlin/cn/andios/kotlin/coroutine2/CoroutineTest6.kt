package cn.andios.kotlin.coroutine2

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

// 我们在使用协程时，如果取消了协程，那么很大一部分原因都在于协程的执行时间超过了某个设定值；
// 我们可以通过手工引用与协程对应的Job的方式来启动一个单独的协程用于取消这个协程，不过kotlin提供了一个
// 内建的函数来帮助我们又快又好的做到了这一点

fun main() = runBlocking {
    withTimeout(1900) {
        repeat(10) {
            println("wc:$it")
            delay(400)
        }
    }
}