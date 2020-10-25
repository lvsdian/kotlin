package cn.andios.kotlin.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    Buffer(缓冲)
    如果让一个flow，它的不同部分执行在不同协程中，从系统角度来看，会减少运行时间
    如下，用buffer对emit进行缓冲，减少等待时间
    buffer会让流元素的发生无需等到，直接发射出来了，等到collect处理完后，直接拿buffer
    中缓冲的元素继续处理，避免了在collect等待的同时，emit操作也在等待

    buffer与flowOn存在一定的关系
    实际上，flowOn运算符本质上在遇到需要改变CoroutineDispatcher是时也会使用同样的缓冲机制，只不过现在这个示例并没有
    改变执行上下文而已（如下，emit和collect执行在同一个上下文）
 */

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        // 模拟一个极为耗时的操作，该操作之后才开始流元素的发射
        delay(100)
        emit(i)
    }
}

fun main = runBlocking<Unit> {
    val time = measureTimeMillis {
        myMethod().buffer().collect{value ->
            delay(200)
            println(value)
        }
    }
    println(time)
}