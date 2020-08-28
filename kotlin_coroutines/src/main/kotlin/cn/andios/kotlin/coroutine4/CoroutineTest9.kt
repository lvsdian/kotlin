package cn.andios.kotlin.coroutine4

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

fun main() = runBlocking<Unit>(CoroutineName("A")) {
    // 用 "+" 拼接多个同类型参数
    launch(Dispatchers.Default + CoroutineName("myCoroutine")) {
        println("thread:${Thread.currentThread().name}")
    }
}