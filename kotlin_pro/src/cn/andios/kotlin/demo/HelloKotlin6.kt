package cn.andios.kotlin.demo

/**
 * @author lvsdian
 * Created on 2020-07-30
 */
fun main(args: Array<String>) {
    var array: IntArray = intArrayOf(1, 2, 3)

    println("遍历方式一")
    for (item in array) {
        print("$item \t")
    }

    println("\n遍历方式二")
    for (i: Int in array.indices) {
        println("array[$i] = ${array[i]}")
    }

    println("\n遍历方式三")
    for ((index, value) in array.withIndex()) {
        println("array[$index] = $value")
    }
}
