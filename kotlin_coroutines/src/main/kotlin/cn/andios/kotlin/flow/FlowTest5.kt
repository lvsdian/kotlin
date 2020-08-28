package cn.andios.kotlin.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// 只有当调用了Flow对象上的终止操作（如collect）之后，Flow才会真正执行
// 当我们调用了method()方法后，它实际上是立刻返回的，并不会去执行其中的代码

private fun method(): Flow<Int> = flow {
    println("method invoked")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

//hello
//world
//method invoked
//1
//2
//3
fun main() = runBlocking<Unit> {
    println("hello")

    val flow = method()

    println("world")

    flow.collect { println(it) }
}