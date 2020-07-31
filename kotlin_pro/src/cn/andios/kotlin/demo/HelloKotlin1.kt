package cn.andios.kotlin.demo

/**
 * @author lvsdian
 * Created on 2020-07-30
 */
fun main(args: Array<String>) {
    println(sum1(1, 2))
    myPrint2(1, 2)

}

fun sum1(a: Int, b:Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int): Int = a + b

fun sum3(a: Int, b: Int) = a + b

/**
 * 无返回值
 */
fun myPrint1(a: Int, b: Int):Unit {
    print(a + b)
}

fun myPrint2(a: Int, b: Int) {
    println(a + b)
    // java：println(a + "+" + b + "=" + (a + b))
    println("$a + $b = ${a + b}")

}