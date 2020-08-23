package cn.andios.kotlin.reflection

import kotlin.reflect.full.functions

class MyTestClass5 {
    fun printSomething(name: String) {
        println("something:$name")
    }

    fun printNothing() {
        println("nothing")
    }
}

fun main(args: Array<String>) {
    val myTestClass5 = MyTestClass5::class
    val testClass5 = MyTestClass5()

    var functionToInvoke = myTestClass5.functions.find { it.name == "printNothing" }
    functionToInvoke?.call(testClass5)      // nothing
}