package cn.andios.kotlin.coroutine4

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */
// 对于父子协程来说，父协程总是会等待其所有子协程的完成，对于父协程来说，它不必显式的去追踪由它所启动的所有子协程，同时也不必调用子协程Job.join()方法来等待子协程的完成

//w
//coroutine 0 invoked
//coroutine 1 invoked
//coroutine 2 invoked
//coroutine 3 invoked
//coroutine 4 invoked
//c
fun main() = runBlocking<Unit> {
    val request = launch {
        repeat(5) {
            launch {
                delay((it + 1) * 100L)
                println("coroutine $it invoked")
            }
        }
        println("w")
    }
    // join：只有request这个Job执行完成时，才会继续往下执行
    request.join()
    println("c")
}