package cn.andios.kotlin.reflection

/**
 * @author lvsdian
 * Created on 2020-08-23
 */

// 函数组合

// 泛型为A，B，C
// 接收两个参数，分别为两个函数：B->C；A->B
// 返回一个函数：A->C
// 方法体：x为传入参数(相当于A)，先调用g函数，A->B，再调用f函数，B->C，最终返回C
fun <A, B, C> myCompose(f: (B) ->C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun isEven(x: Int) = 0 == x % 2
fun length(s: String) = s.length

fun main(args: Array<String>) {
    val evenLength = myCompose(:: isEven, ::length)
    val str = listOf("how", "when", "why", "what", "which")

    // 打印出list中长度为偶数的元素
    println(str.filter(evenLength))
}
