package cn.andios.kotlin.reflection

import kotlin.reflect.full.memberProperties

/**
 * @author lvsdian
 * Created on 2020-08-24
 */

class MyTestClass6 {
    var name: String = "hello"
}

fun main() {
    val myTestClass6 = MyTestClass6::class
    var testClass6 = MyTestClass6()

    var variableToInvoke = myTestClass6.memberProperties.find { it.name == "name" }
    println(variableToInvoke?.get(testClass6))      // hello
    println(variableToInvoke?.call(testClass6))     // hello

}
