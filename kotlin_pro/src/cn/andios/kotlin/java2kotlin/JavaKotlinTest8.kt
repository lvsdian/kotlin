@file:JvmName("Test8")


package cn.andios.kotlin.java2kotlin

/**
 * @author lvsdian
 * Created on 2020-08-22
 */

fun List<String>.myFilter(): List<String> {
    return listOf("hello", "world")
}

// 如果这里不用@JvmName起个别名，会与上面的方法冲突
@JvmName("myFilter2")
fun List<Int>.myFilter(): List<Int> {
    return listOf(1, 2)
}

// 在kotlin中调用，可以直接根据list的类型来区分，不需要用@JvmName定义的名字
fun main(args: Array<String>) {
    val list1 = listOf<String>()
    println(list1.myFilter())

    val list2 = listOf<Int>()
    println(list2.myFilter())
}
