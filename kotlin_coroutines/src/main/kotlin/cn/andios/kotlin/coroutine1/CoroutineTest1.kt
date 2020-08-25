package cn.andios.kotlin.coroutine1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

fun main(args: Array<String>) {
    // 协程等待，线程打印hello，线程等待2s，协程打印kotlin coroutine,线程打印world
    GlobalScope.launch {
        // delay使协程等待，不会让线程等待
        delay(1000)
        println("kotlin coroutine")
    }
    println("hello")
    Thread.sleep(2000)
    println("world")

    // 协程等待，线程打印hello，线程等待500ms，线程打印world，线程退出（线程退出后，协程不执行了，不会打印kotlin coroutine）
    GlobalScope.launch {
        // delay使协程等待，不会让线程等待
        delay(1000)
        println("kotlin coroutine")
    }
    println("hello")
    Thread.sleep(500)
    println("world")
}
