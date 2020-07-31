package cn.andios.kotlin.demo

/**
 * @author lvsdian
 * Created on 2020-07-30
 */
fun main(args: Array<String>) {
    println(myPrint1("hello"))
    println(myPrint2("world"))
    println(myPrint3("hello world"))

    println("****************")

    println(myNum(10))
}

fun myPrint1(str: String): String{
    return when(str) {
        "hello" -> "HELLO"
        "world" -> "WORLD"
        else -> "other input"
    }
}

fun myPrint2(str: String): String =
    when(str) {
        "hello" -> "HELLO"
        "world" -> "WORLD"
        else -> "other input"
    }

fun myPrint3(str: String) =
    when(str) {
        "hello" -> "HELLO"
        "world" -> "WORLD"
        else -> "other input"
    }

fun myNum(num: Int): Int {
    return when (num) {
        1 -> {
            println("a = 1")
            10
        }
        2 -> {
            println("a = 2")
            20
        }
        3, 4, 5 -> {
            println("a = 3 or 4 or 5")
            30
        }
        // 闭区间
        in 6..10 -> {
            println("a is between 6 and 10")
            40
        }
        else -> {
            println("a is other value")
            50
        }
    }
}