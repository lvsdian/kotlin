package cn.andios.kotlin.kotlin2java

fun main(args: Array<String>) {

    val clazz1 = MyException()::class.java
    val clazz2 = MyException().javaClass
    println("clazz1:$clazz1")
    println("clazz2:$clazz2")

    println("---------------------")

    val myException = MyException()
    // java中抛出异常，kotlin中可不做处理
    myException.myMethod()
}