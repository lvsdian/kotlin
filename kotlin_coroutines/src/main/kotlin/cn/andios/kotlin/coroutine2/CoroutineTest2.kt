package cn.andios.kotlin.coroutine2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

// kotlinx.coroutines包下的所有挂起函数都是可取消的
// 它们会检查协程的取消状态，当取消时就会抛出CancellationException异常
// 不过，如果协程正在处于某个计算过程当中，并且没有检查取消状态，那么它就是无法被取消的

// 如下，打印完hello后，应该执行job.cancelAndJoin()进而取消协程，但实际并没有，只有当i = 20不符合while条件时才退出
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch (Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 20) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job:${i ++}")
                nextPrintTime += 1000L
            }
        }
    }
    delay(1300)
    println("hello")

    job.cancelAndJoin()
    println("world")
}