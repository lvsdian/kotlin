package cn.andios.kotlin.coroutine1

import kotlin.concurrent.thread

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

// 用线程方式实现CoroutineTest1中的代码
fun main(args: Array<String>) {

    thread {
        Thread.sleep(1000)
        println("kotlin coroutine")
    }
//    上面的调用方式是这种方式的简写
//    thread(block = {
//        Thread.sleep(1000)
//        println("kotlin nb")
//    })

    println("hello")
    Thread.sleep(500)
    println("world")
}
