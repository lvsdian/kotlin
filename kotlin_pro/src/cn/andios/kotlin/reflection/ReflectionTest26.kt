package cn.andios.kotlin.reflection

import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.jvm.javaSetter

class MyTestClass14{
    var name: String = "okk"
    val price: Double = 11.1
}

var myTest = "myTest"

fun main(args: Array<String>) {
    val topProp = ::myTest
    // private static java.lang.String cn.andios.kotlin.reflection.ReflectionTest26Kt.myTest
    println(topProp.javaField)

    // public static final java.lang.String cn.andios.kotlin.reflection.ReflectionTest26Kt.getMyTest()
    println(topProp.javaGetter)
    // public static final void cn.andios.kotlin.reflection.ReflectionTest26Kt.setMyTest(java.lang.String)
    println(topProp.javaSetter)

    val n = MyTestClass14::name
    // private java.lang.String cn.andios.kotlin.reflection.MyTestClass14.name
    println(n.javaField)
    // public final java.lang.String cn.andios.kotlin.reflection.MyTestClass14.getName()
    println(n.javaGetter)
    // public final void cn.andios.kotlin.reflection.MyTestClass14.setName(java.lang.String)
    println(n.javaSetter)

    val prop = MyTestClass14::price
    // private final double cn.andios.kotlin.reflection.MyTestClass14.price
    println(prop.javaField)
    // public final double cn.andios.kotlin.reflection.MyTestClass14.getPrice()
    println(prop.javaGetter)
    // price是val，没有prop.javaSetter
}