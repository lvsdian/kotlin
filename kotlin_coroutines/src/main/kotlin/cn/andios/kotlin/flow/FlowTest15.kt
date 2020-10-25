package cn.andios.kotlin.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private fun log(msg: String) = println("[${Thread.currentThread().name}], $msg")

// 如下，流的emit操作显式指定在Dispatchers.Default这个分发器中去完成的，
// 而不管它的collect操作处在哪个上下文
private fun myMethod(): Flow<Int> = flow{
    for (i in 1..4) {
        Thread.sleep(100)
        log("Emit:$i")
        emit(i)
    }
}.flowOn(Dispatchers.Default)

// 借助于flowOn，可以让Flow在发射元素时所处的上下文与收集(终止操作)时所处的上下文是不同的，
// 值得注意的是：flowOn运算符改变了flow本身默认的顺序性
// 现在，收集操作实际上是发生在一个协程当中，而发生操作发生在另一个协程当中（这一点至关重要）
// flowOn运算符本质上会改变上下文中的CoroutineDispatcher，并且为上游的flow创建另一个协程
fun main() = runBlocking{
    myMethod().collect{ value ->
        log("collected:$value")
    }
}


