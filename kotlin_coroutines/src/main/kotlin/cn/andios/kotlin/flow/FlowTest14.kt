package cn.andios.kotlin.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private fun myMethod(): Flow<Int> = flow{
    withContext(Dispatchers.Default) {
        for (i in 1..4) {
            Thread.sleep(100)
            emit(i)
        }
    }
}

// myMethod方法阻塞住了，会影响main线程执行，这里指定Dispatchers.Default，让myMethod方法在
// 另一个线程池中执行，以免影响main线程执行
// 但运行会报错，因为这样flow的emit与collect是在不同的context中执行的，违背了flow的不变性
fun main() = runBlocking{
    myMethod().collect{ println(it) }
}
