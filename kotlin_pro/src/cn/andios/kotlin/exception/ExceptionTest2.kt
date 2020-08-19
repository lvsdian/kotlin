package cn.andios.kotlin.exception

// throw在kotlin中是个表达式，这样我们可以将throw作为Elvis表达式的一部分
// throw表达式的类型是一种特殊类型：Nothing.这种类型是没有值的，用于标记永远不会触达的代码的位置
// 在自己的代码中，可以使用Nothing来标记永远不会返回的函数

fun main(args: Array<String>) {
    val str1: String? = "a"
    // Elvis表达式：如下"?:"形式，如果"?"前面的str1不为null，就把str1赋给str2,否则把":"后面的表达式赋给str2
    val str2 = str1 ?: throw IllegalArgumentException("值不能为空")

    println(str2)

    println("----------------------------------")

    val str3 = str1 ?: myMethod("hello")

    println("----------------------------------")

    var s1 = null
    println(s1 is Nothing) // false
    println(s1 is Nothing?) //true

    var s2 = listOf(null)
    println(s2 is List<Nothing?>) // true


}

fun myMethod(message: String): Nothing {
    throw IllegalArgumentException(message)
}