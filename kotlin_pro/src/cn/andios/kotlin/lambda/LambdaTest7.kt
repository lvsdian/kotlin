package cn.andios.kotlin.lambda

/**
 * @author lvsdian
 * Created on 2020-08-05
 */

// 匿名函数
fun main(args: Array<String>) {
    var strs = arrayOf("hello", "world", "bye")
    // lambda方式
    strs.filter { it.length > 3 }.forEach { println(it) }
    // 匿名函数方式
    strs.filter(
        fun(item): Boolean = item.length > 3
    ).forEach(
        fun(item){
            println(item)
        }
    )
}
