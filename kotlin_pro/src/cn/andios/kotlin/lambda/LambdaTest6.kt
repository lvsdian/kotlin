package cn.andios.kotlin.lambda

/**
 * @author lvsdian
 * Created on 2020-08-05
 */

// 默认情况下，lambda表达式最后一个表达式的值会隐式作为该lambda表达式的返回值
// 我们也可以通过全限定的return语法来显式从lambda表达式返回值

fun main(args: Array<String>) {
    val strs = arrayOf("hello", "world", "bye")

    // mayFilter隐式作为返回值
    strs.filter {
        val mayFilter = it.length > 3
        mayFilter
    }

    // 全限定的方式返回值（return + @ + lambda方法名）
    strs.filter {
        val mayFilter = it.length > 3
        return@filter mayFilter
    }
}
