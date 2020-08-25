package cn.andios.kotlin.coroutine1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

fun main() = runBlocking {
    // 协程打印hello，协程等待myJob执行，myJob打印kotlin coroutine，协程打印world
    val myJob: Job = GlobalScope.launch {
        delay(1000)
        println("kotlin coroutine")
    }
    println("hello")
    // join()：挂起协程（runBlocking启动的协程），直到它（myJob）运行完成
    myJob.join()
    println("world")
}
