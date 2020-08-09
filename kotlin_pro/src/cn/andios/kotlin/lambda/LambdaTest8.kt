package cn.andios.kotlin.lambda

/**
 * @author lvsdian
 * Created on 2020-08-05
 */

// 闭包

fun main(args: Array<String>) {
    var sum = ""

    val strs = arrayOf("hello", "world", "byt")

    // 闭包：即在lambda表达式中允许访问其外层的变量，比如这里sum是定义在外层的，但在lambda表达式中可以访问
    strs.filter { it.length > 3 }
        .forEach { sum += it }
    println(sum)
}
