package cn.andios.kotlin.reflection

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredFunctions

class MyTestClass11 {
    fun method(message: String) {
        println("执行带String参数的方法：$message")
    }
    fun method(message: String, price: Double) {
        println("执行带String, Double参数的方法：$message, $price")
    }
}

fun main(args: Array<String>) {
    val clazz = MyTestClass11::class
    val instance = clazz.createInstance()

    val funs = clazz.declaredFunctions

    for (f in funs) {
        // 这里的3，表示3个参数，其中包含实例这个参数，所以真正的方法的参数是2个
        if (f.parameters.size == 3) {
            f.call(instance, "Ruby", 22)    // 执行带String, Double参数的方法：Ruby, 22.0
        }

    }
}