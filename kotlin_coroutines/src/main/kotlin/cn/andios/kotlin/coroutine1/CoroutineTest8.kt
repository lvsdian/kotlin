package cn.andios.kotlin.coroutine1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

// 协程是轻量级的
// repeat：将action执行times次，每次遍历times的索引会作为参数传给action
fun main() = runBlocking {
    // 创建非常多的协程，不会OOM
    repeat(99999999) {
        launch {
            delay(1000)
            println("A")
        }
    }
    println("hello")


    // 创建非常多的线程，OOM，就算不OOM，速度也比协程慢
    repeat(10000000) {
        thread {
            Thread.sleep(1000)
            println("B")
        }
    }
    println("world")
}
