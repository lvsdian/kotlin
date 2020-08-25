package cn.andios.kotlin.coroutine1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-25
 */
// 每一个协程构建器（包括runBlocking）都会向其代码块作用域中添加一个CoroutineScope实例，我们可以在该作用域中
// 启动协程，而无需显式将其join到一起，这是因为外部协程(在下面的实例中就是runBlocking)会等待该作用域中的所有启动的协程全部完成后才会完成。

fun main() = runBlocking {
    // hello --> kotlin
    launch {
        delay(1000)
        println("kotlin")
    }
    println("hello")
}
