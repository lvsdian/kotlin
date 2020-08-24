package cn.andios.kotlin.reflection

import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties

/**
 * @author lvsdian
 * Created on 2020-08-24
 */

class MyTestClass7 {
    var name: String = "hello"
    var authorName: String = "Bob"
}

fun main(args: Array<String>) {
    val myTestClass7 = MyTestClass7::class
    var testClass7 = MyTestClass7()

    var variableToInvoke = myTestClass7.memberProperties.find { it.name == "name" }
    println(variableToInvoke?.get(testClass7))      // hello


    // 如果是KMutableProperty类型，就调用它的setter方法赋值
    if (variableToInvoke is KMutableProperty<*>) {
        variableToInvoke.setter.call(testClass7, "wc")
    }

    println(variableToInvoke?.get(testClass7))      // wc
}
