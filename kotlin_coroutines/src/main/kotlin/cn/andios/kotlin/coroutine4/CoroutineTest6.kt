package cn.andios.kotlin.coroutine4

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-27
 */
// 父子协程之间的关系
// 当一个协程是通过另一个协程的CoroutineScope来启动的，那么这个协程就会通过CoroutineScope.coroutineContext来继承其上下文信息
// 同时，新协程的Job就会成为父协程Job的一个孩子；当父协程被取消执行时，该父协程的所有孩子都会通过递归的方式一并去取消
// 特殊情况：当我们使用GlobalScope来启动协程时，对于启动的新协程来说，其Job是没有父Job的，因此，它就不会绑定到其所启动的那个范围上，
// 故其可以独立执行（这是一种特殊情况）

// job1 --> job3 --> job2 --> wc
// 因为外层的request被cancel，所以job4不会打印
fun main() = runBlocking<Unit> {
    val request = launch {
        GlobalScope.launch {
            println("job1")
            delay(2000)
            println("job2")
        }
        launch {
            delay(100)
            println("job3")
            delay(1000)
            println("job4")
        }
    }
    delay(1000)
    request.cancel()

    delay(1500)
    println("wc")
}
