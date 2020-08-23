package cn.andios.kotlin.reflection

import java.io.Serializable
import kotlin.reflect.full.superclasses

class MySerializable: Serializable, MyInterface

fun main(args: Array<String>) {
    val mySerializableType = MySerializable::class
    println(mySerializableType.superclasses)        // [class java.io.Serializable, class cn.andios.kotlin.reflection.MyInterface, class kotlin.Any]
}

interface MyInterface