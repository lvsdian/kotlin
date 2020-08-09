package cn.andios.kotlin.lambda

/**
 * @author lvsdian
 * Created on 2020-08-05
 */

// 内联函数 (inline function)
// 如果一个方法A调用了B，内联函数就是把B整个方法体的代码原封不动的拷贝到被调用处
// 缺点：代码不能复用，导致字节码的膨胀
// 定义内联函数时需要用Inline修饰
inline fun myCalculate(a: Int, b: Int) = a + b

fun main(args: Array<String>) {
    println(myCalculate(1, 2))
}
