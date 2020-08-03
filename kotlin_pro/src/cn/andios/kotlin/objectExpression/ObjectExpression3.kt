package cn.andios.kotlin.objectExpression

/**
 * @author lvsdian
 * Created on 2020-08-02
 */

// 类似于java的匿名内部类，kotlin对象表达式中的代码是可以访问到外层的变量
// 与java不同的是，外层变量无需声明为final

fun main(args: Array<String>) {
    var i = 100

    // 这里是在方法中声明，所以要被识别为对象表达式，无需用private修饰
    var myObject = object {
        fun myMethod() {
            i ++
        }
    }

    myObject.myMethod()
    println(i)
}
