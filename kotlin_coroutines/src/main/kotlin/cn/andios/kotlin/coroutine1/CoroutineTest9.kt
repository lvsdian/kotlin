package cn.andios.kotlin.coroutine1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

// suspend用来修饰函数，被suspend修饰的函数叫做挂起函数
// 挂起函数（suspending function）
//  1.挂起函数可以像普通函数一样用在协程中，不过它的一个特性在于可以使用其它的挂起函数
//  2.挂起函数只能用在协程或者另一个挂起函数中

fun main(args: Array<String>) {
    runBlocking {
        launch {
            world()
        }
    }
}

suspend fun hello() {
    delay(1000)
    println("fun invoked")
}

// 挂起函数
suspend fun world() {
    hello()
}
