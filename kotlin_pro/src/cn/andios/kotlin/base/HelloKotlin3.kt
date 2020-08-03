package cn.andios.kotlin.base

/**
 * @author lvsdian
 * Created on 2020-07-30
 */
fun main(args: Array<String>){
    var x = 10
    var y = 30

    var max1: Int
    var min1: Int

    if (x > y) {
        max1 = x
        min1 = y
    } else {
        max1 = y
        min1 = x
    }
    println("java方式：max = $max1, min = $min1")

    var m = 10
    var n = 20

    var max2 = if (m > n) m else n
    var min2 = if (m > n) n else m
    println("kotlin方式1：max2 = $max2, min2 = $min2")

    var p = 10
    var q = 30

    var max3 = if (p > q) {
        println("p > q")
        p
    } else {
        println("p <= q")
        q
    }
    var min3 = if (p <= q) {
        println("p <= q")
        q
    } else {
        println("p > q")
        p
    }

    println("kotlin方式2：max3 = $max3, min3 = $min3")
}