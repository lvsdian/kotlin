package cn.andios.kotlin.reflection

import kotlin.reflect.full.memberFunctions

class MyTestClass3 {
    fun printSomething(){
        println("something")
    }
    fun printNothing(){
        println("nothing")
    }
}

fun main(args: Array<String>) {
    val myTestClass3 = MyTestClass3::class
    // [fun cn.andios.kotlin.reflection.MyTestClass3.printNothing(): kotlin.Unit, fun cn.andios.kotlin.reflection.MyTestClass3.printSomething(): kotlin.Unit, fun kotlin.Any.equals(kotlin.Any?): kotlin.Boolean, fun kotlin.Any.hashCode(): kotlin.Int, fun kotlin.Any.toString(): kotlin.String]
    println(myTestClass3.memberFunctions)
}