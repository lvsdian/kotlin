package cn.andios.kotlin.lambda

/**
 * @author lvsdian
 * Created on 2020-08-05
 */

fun main(args: Array<String>) {
    val strs = arrayOf("hello", "world", "helloA", "welcome")

    println(strs.filter { it.length > 5 })

    strs.filter { it.endsWith(suffix = "d", ignoreCase = true) }.map { it.toUpperCase() }.forEach { println(it) }
}
