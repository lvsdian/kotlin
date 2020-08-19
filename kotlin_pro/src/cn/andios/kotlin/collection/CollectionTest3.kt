package cn.andios.kotlin.collection

/**
 * @author lvsdian
 * Created on 2020-08-16
 */

// Range

fun main(args: Array<String>) {
    var i = 5
    // 判断i是否在[1, 5]之间
    if ( i in 1..5 ) {
        println(i)
    }

    println("--------------")

    // 打印1-5
    for (a in 1..5) {
        print("$a\t")
    }

    println("\n-------------")

    // 打印5-1
    for (a in 5 downTo 1) {
        print("$a\t")
    }

    println("\n------------")

    // 打印1-10，一次跳两个
    // 1	3	5	7	9
    for (a in 1..10 step 2) {
        print("$a\t")
    }

    println("\n------------")

    // 打印10-1，一次跳两个
    // 10 8 6 4 2
    for (a in 10 downTo 1 step 2) {
        print("$a\t")
    }
}
