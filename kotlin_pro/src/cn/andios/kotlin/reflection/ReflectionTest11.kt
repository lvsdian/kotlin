package cn.andios.kotlin.reflection

import kotlin.reflect.KClass

fun main(args: Array<String>) {
    val kotlinLang = "kotlin"
    val kClass1: KClass<out String> = kotlinLang::class
    println(kClass1)             // class kotlin.String

    println("-----------------------")

    val kClassDataType: KClass<String> = String::class
    println(kClassDataType)     // class kotlin.String

    val kClass2 = Class.forName("java.util.Date").kotlin
    println(kClass2)            // class java.util.Date




}
