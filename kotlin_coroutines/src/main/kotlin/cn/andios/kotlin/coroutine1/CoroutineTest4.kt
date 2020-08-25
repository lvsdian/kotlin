package cn.andios.kotlin.coroutine1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

fun main() = runBlocking {
    // hello --> kotlin --> world
    GlobalScope.launch {
        delay(1000)
        println("kotlin")
    }
    println("hello")
    delay(2000)
    println("world")

    //hello --> world
    GlobalScope.launch {
        delay(1000)
        println("kotlin")
    }
    println("hello")
    delay(500)
    println("world")
}
