package cn.andios.kotlin.coroutine4

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

/**
 * @author lvsdian
 * Created on 2020-08-27
 */

// Job的使用方式及在Context中的具体应用
// 协程的Job是归属其上下文的一部分，kotlin为我们提供了一种简洁的手段来通过协程上下文获取到协程自身的Job对象
// 我们可以通过coroutineContext[Job]表达式来访问上下文中的Job对象

fun main() = runBlocking<Unit> {
    // runBlocking第二个参数是
    val job: Job? = coroutineContext[Job]
    println(job)  // "coroutine#1":BlockingCoroutine{Active}@621be5d1

    println(coroutineContext.isActive)  // true
}