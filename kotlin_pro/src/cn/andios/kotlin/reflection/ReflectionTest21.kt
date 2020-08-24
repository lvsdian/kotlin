package cn.andios.kotlin.reflection

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.functions

class MyTestClass9(value: Int = 0) {
    fun printSomething() {
        println("something")
    }

    fun printNothing() {
        println("nothing")
    }
}

fun main(args: Array<String>) {
    val myTestClass9 = MyTestClass9::class
    val myOjb = myTestClass9.createInstance()

    myTestClass9.functions.find { it.name == "printSomething" }?.call(myOjb)
    myTestClass9.functions.find { it.name == "printNothing" }?.call(myOjb)
}