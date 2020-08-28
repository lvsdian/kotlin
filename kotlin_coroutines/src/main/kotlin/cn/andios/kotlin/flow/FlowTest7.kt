package cn.andios.kotlin.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// Flow builder(流构建器)
// 1.flow是最经常被使用的一种流构建器
// 2.flowOf构建器可用于定义能够发射固定数量值的流
// 3.对于各种集合与序列来说，它们都提供了asFlow()扩展方法来将自身转换为Flow

// inline：方法调用时，并不是采用method invocation方式，而是将调用的方法的代码原封不到的复制到使用处，减少了一次方法调用
// noinline
// crossinline：也是一个关键字，kotlin中有一个non-local returns(非局部返回)：在一个方法中，如果这个方法里面又执行了一个方法或执行了一个lambda表达式
//      里面执行的方法或者表达式也是可能有返回值的，正常情况下，其返回值是不能表示外层方法的返回值的，如果将这个返回值作为外层方法的返回值就叫非局部返回。
//      crossinline作用：被标记的lambda表达式是不允许非局部返回的，必须要通过外层方法特定的return语句返回

fun main() = runBlocking {
    (1..5).asFlow().collect { println(it) }

    println("-----------")

    flowOf(10, 20, 30).collect { println(it) }
}