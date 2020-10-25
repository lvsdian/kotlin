package cn.andios.kotlin.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking

/*
    flow的组合
 */

fun main() = runBlocking<Unit> {
    val nums = (1..5).asFlow()
    val strs = flowOf("one", "two", "three", "four", "five")

    // zip实现两个流变为一个流
    nums.zip(strs) {a, b -> "$a -> $b"}.collect { println(it) }

}