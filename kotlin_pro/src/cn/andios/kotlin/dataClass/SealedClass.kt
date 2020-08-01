package cn.andios.kotlin.dataClass

/**
 * @author lvsdian
 * Created on 2020-07-31
 */

// 密封类（sealed class）
// 当某个值可以拥有一个受限的集合其中的类型之一，不能是其他任何类型，它就可以是一个密封类
// 密封类的子类可以有多个实例，密封类和它的直接子类必须在同一个文件中
// 密封类本身是抽象的，不能实例化

// 定义一个密封类Calculator
sealed class Calculator

class Add: Calculator()

class Subtract: Calculator()

class Multiply: Calculator()

fun calculate(a: Int, b: Int, cal: Calculator) = when (cal) {
    is Add -> a + b
    is Subtract -> a - b
    else -> a * b
}

fun main(args: Array<String>) {
    println(calculate(1, 2, Add()))
    println(calculate(1, 2, Subtract()))
    println(calculate(1, 2, Multiply()))
}