package cn.andios.kotlin.lambda

import java.util.function.Function

/**
 * @author lvsdian
 * Created on 2020-08-05
 */

// calculate函数作为一个参数传递，接收两个整型，返回一个整型
fun myCalculate(a: Int, b: Int, calculate: (Int, Int) -> Int): Int {
    return calculate(a , b)
}

fun main(args: Array<String>) {
    println(myCalculate(1 , 2){a, b -> a + b})
    println(myCalculate(1 , 2){a, b -> a - b})
    println(myCalculate(1 , 2){a, b -> a * b})
    println(myCalculate(1 , 2){a, b -> a / b})
}
