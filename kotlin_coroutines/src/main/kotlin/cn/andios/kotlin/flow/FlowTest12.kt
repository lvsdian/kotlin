package cn.andios.kotlin.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// Flow是顺序执行的
// 对于Flow的收集操作来说，它是运行在调用了终止操作的那个协程上，默认情况下，他是不会启动新的协程的，每个emit的元素值都会由所有的中间操作进行处理
// 最后再由终止操作进行处理， 本质上，就是由上游进入到了下游

fun main() = runBlocking {
    (1..4).asFlow()
        .filter {
            println("filter:$it")
            it % 2 == 0
        }
        .map {
            println("map:$it")
        }
        .collect {
            println("collect:${it}")
        }
}