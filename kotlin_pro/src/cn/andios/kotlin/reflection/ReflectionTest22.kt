package cn.andios.kotlin.reflection

import kotlin.reflect.full.createInstance

class MyTestClass10(var name: String) {
    var price = 0.0
    constructor(): this("未知商品") {
        this.price = 0.0
    }
    constructor(name: String, price: Double): this(name) {
        this.price = price
    }
}

fun main(args: Array<String>) {
    val clazz = MyTestClass10::class

    // 调用不带参数的构造方法
    val instance1 = clazz.createInstance()
    println(instance1.name)
    println(instance1.price)

    // 调用带参数的构造方法
    val cons =clazz.constructors
    cons.forEach {
        if (it.parameters.size == 2) {
            val instance2 = it.call("《活着》", 999)

            println(instance2.name)
            println(instance2.price)
        }
    }
}