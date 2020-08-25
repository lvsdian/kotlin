package cn.andios.kotlin.coroutine2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

// 有两种方式可以让计算代码变为可取消的
// 1.周期性的调用一个挂起函数，该挂起函数会检查取消状态，比如说使用yield函数
// 2.显示的检查取消状态
// 如下采取第二种方式
// 所以这里打印hello后，协程退出，打印well，不像CoroutineTest2中一样
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch (Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) {
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