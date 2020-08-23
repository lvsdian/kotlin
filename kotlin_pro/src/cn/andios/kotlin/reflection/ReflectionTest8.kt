package cn.andios.kotlin.reflection

import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

class T(val x: Int)

fun main(args: Array<String>) {
    println(T::x)               // val cn.andios.kotlin.reflection.T.x: kotlin.Int
    println(T::x.javaGetter)    // public final int cn.andios.kotlin.reflection.T.getX()
    println(T::x.javaField)     // private final int cn.andios.kotlin.reflection.T.x

    println("---------------------------")

    println(T(10).javaClass)        // class cn.andios.kotlin.reflection.T
    println(T(10).javaClass.kotlin) // class cn.andios.kotlin.reflection.T

    println(String.javaClass)           // class kotlin.jvm.internal.StringCompanionObject
    println(String.javaClass.kotlin)    // class kotlin.String$Companion
}