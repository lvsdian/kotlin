package cn.andios.kotlin.coroutine2

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

// 使用finally来关闭资源
// join与cancelAndJoi都会等待所有清理动作完成才会继续往下执行

// 打印三次后，等finally块执行完后，协程才会真正退出
fun main() = runBlocking {
    val myJob = launch {
        try {
            repeat(10) {
                println("wc:$it")
                delay(500)
            }
        }finally {
            println("finally invoked")
        }
    }
    delay(1300)
    println("hello")

    myJob.cancelAndJoin()
    println("world")
}