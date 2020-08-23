package cn.andios.kotlin.reflection

import kotlin.reflect.full.memberProperties

class MyTestClass2(var name: String, val flag: Boolean, var age: Int) {
}

fun main(args: Array<String>) {
    val myTestClass2 = MyTestClass2::class
    // [var cn.andios.kotlin.reflection.MyTestClass2.age: kotlin.Int, val cn.andios.kotlin.reflection.MyTestClass2.flag: kotlin.Boolean, var cn.andios.kotlin.reflection.MyTestClass2.name: kotlin.String]
    println(myTestClass2.memberProperties)
}