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

    var functionToInvoke1 = myTestClass5.functions.find { it.name == "printNothing" }
    functionToInvoke1?.call(testClass5)      // nothing

    var functionToInvoke2 = myTestClass5.functions.find { it.name == "printSomething" }
    functionToInvoke2?.call(testClass5, "something")        // something:something
}