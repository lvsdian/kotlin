package cn.andios.kotlin.demo

// 导包
// import cn.andios.kotlin.demo2.mul
// 别名导包，设置别名后，原来的mul就不能用了
import cn.andios.kotlin.demo2.mul as multiply

/**
 * @author lvsdian
 * Created on 2020-07-30
 */
fun main(args: Array<String>) {
    // val：常量
    val a: Int = 1
    // 修改a的值会报错
    // a = 2

    // var：变量
    var b: Double = 0.1
    b = 0.2

    println("a: $a")
    println("b: $b")

    var x = 10
    var y: Byte = 20
    // 小范围（Byte）变量赋值给大范围（Int）不允许，java允许
    // x = y
    // 大范围（Int）变量赋值给小范围（Byte）不允许，java也不允许
    // y = x
    x = y.toInt()
    println("x: $x")
    println("y: $y")

    println("导包演示：x * y = ${multiply(x, y.toInt())}")

    // 常量m
    val m = intArrayOf(1, 2, 3)
    // 修改引用，报错
    // m = intArrayOf(1, 2, 3, 4)
    // 修改m，把第1个元素改为2
    m[0] = 2
    for (item in m) {
        print("$item  \t")
    }
}
