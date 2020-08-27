package cn.andios.kotlin.coroutine4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-27
 */
// Dispatchers.Unconfined
// 这个协程分发器它会在调用者线程中去启动协程，但仅仅会持续到第一个挂起点，当挂起结束后，程序恢复执行时，它会继续
// 协程代码的执行，但这时执行协程的线程是由之前所调用的挂起函数来决定的（挂起函数是由哪个线程来执行的，那么后面的代码就会由这个
// 线程执行）。Dispatchers.Unconfined协程分发器适用于这样的一些协程：它既不会消耗CPU时间，同时也不会更新任何共享的数据
// Dispatchers.Unconfined是一种高级的机制，它对于某些特殊情况是很有帮助作用的：协程执行的分发是不需要的，或者会产生意料之外的副作用，
// 这是因为协程中的操作必须要立刻执行
// 我们在日常的代码编写中，几乎不会使用Dispatchers.Unconfined这种协程分发器
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Unconfined) {
        // Dispatchers.Unconfined,thread:main
        println("Dispatchers.Unconfined,thread:${Thread.currentThread().name}")
        delay(300)
        // Dispatchers.Unconfined,thread:kotlinx.coroutines.DefaultExecutor
        println("Dispatchers.Unconfined,thread:${Thread.currentThread().name}")
    }
    launch {
        println("no params,thread:${Thread.currentThread().name}")
        delay(2000)
        println("no params,thread:${Thread.currentThread().name}")

    }
}