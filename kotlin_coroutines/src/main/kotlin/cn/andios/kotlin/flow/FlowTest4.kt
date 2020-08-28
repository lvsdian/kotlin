package cn.andios.kotlin.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// 如果返回List<String>结果类型，那么就表示只能一次性返回所有值，要想能够表示可以异步计算的流式的值，我们可以使用Flow<String>类型
// 它非常类型于Sequence<String>类型，但其值是异步计算的
// 1.Flow的构建器是通过flow来实现的
// 2.位于flow{ }构建器中的代码是可以挂起的
// 3.myMethod()方法无需再使用suspend标识符，只是通过emit函数发射出来的
// 4.Flow里面的值是通过collect方法收集的

// 结果：launch块与myMethod()的调用交替进行
fun main() = runBlocking<Unit> {
    launch {
        for (i in 1..5) {
            println("is $i")
            delay(200)
        }
    }
    myMethod().collect { println(it) }
}

private fun myMethod(): Flow<Int>  = flow {
    for (i in 1..5) {
        delay(100)
        emit(i)
    }
}