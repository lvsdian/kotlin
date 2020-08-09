package cn.andios.kotlin.lambda

/**
 * @author lvsdian
 * Created on 2020-08-05
 */

// 高阶函数(high-order function)
// lambda表达式格式要求：
// 1.一个lambda表达式总是被一对{}所包围
// 2.其参数（如果有的话）位于 -> 之前（参数类型可省略）
// 3.执行体位于 -> 之后
// 在kotlin中，如果一个函数的最后一个参数是一个函数，那么可以将lambda表达式作为实参传递进去
// 并且可以在调用时方法圆括号外去使用

val multiply: (Int, Int) -> Int = { a, b -> a + b}

val add: (Int, Int) -> Int = {a , b -> a + b}

val subtract = {a: Int, b: Int -> a -b}

val myAction = { println("helo")}

val mayReturnNull: (Int ,Int) -> Int? = { _, _ -> null }

val functionMayBeNull: ((Int, Int) -> Int)? = null
