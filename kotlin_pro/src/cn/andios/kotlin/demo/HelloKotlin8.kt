package cn.andios.kotlin.demo

/**
 * @author lvsdian
 * Created on 2020-07-30
 */
fun main(args: Array<String>) {
    val a = 6

    if (a in 2..10) {
        println("a is in the range")
    }

    if (a !in 2..10) {
        println("a is not in the range")
    }

    if (a in 2..10 step 2) {
        println(a)
    }

    if (a in 10 downTo 2 step 4) {
        println(a)
    }
}