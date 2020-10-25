package cn.andios.kotlin.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// Flow的取消
// Flow的取消实际上与协程之间是一种协同的关系；对于Flow来说，它自身并没有引入任何新的取消点这样的概念
// 它对于取消是完全透明的
// Flow的收集操作是可以取消的，前提是Flow在一个可取消的挂起函数（如delay）中被挂起了，除此之外，我们无法通过其它方式来取消Flow的执行

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        delay(100)
        println("Emit:$i")
        emit(i)
    }
}

// Emit:1
// 1
// Emit:2
// 2
// finished
fun main() = runBlocking {
    // 总时间是250ms，myMethod执行两次是200ms，执行3次超过了250ms，就会被取消
    withTimeoutOrNull(250) {
        myMethod().collect { println(it) }
    }
    println("finished")
}