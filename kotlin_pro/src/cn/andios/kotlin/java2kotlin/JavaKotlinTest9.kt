package cn.andios.kotlin.java2kotlin

/**
 * @author lvsdian
 * Created on 2020-08-22
 */

class Test9 {
    val a: Int
        @JvmName("getAValue")
        get() = 20

    fun getA() = 30
}

fun main() {
    val test9 = Test9()
    println(test9.a)
    println(test9.getA())
}
