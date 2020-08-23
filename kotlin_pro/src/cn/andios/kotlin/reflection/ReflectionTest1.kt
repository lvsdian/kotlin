package cn.andios.kotlin.reflection

/**
 * @author lvsdian
 * Created on 2020-08-23
 */

fun main(args: Array<String>) {
    // c1是KClass类型
    val c1 = String::class
    println(c1) // class kotlin.String

    // c2是Java中的Class类型
    val c2 = String::class.java
    println(c2) // class java.lang.String

}
