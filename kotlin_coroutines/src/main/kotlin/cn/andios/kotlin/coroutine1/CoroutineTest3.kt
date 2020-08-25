package cn.andios.kotlin.coroutine1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

fun main(args: Array<String>) {
    // 协程阻塞1s，线程打印hello，执行runBlocking创建协程，并阻塞主线程2s,原来的协程打印kotlin coroutine，主线程打印world
    GlobalScope.launch {
        delay(1000)
        println("kotlin coroutine")
    }
    println("hello")
    runBlocking {
        delay(2000)
    }
    println("world")
}
