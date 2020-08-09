package cn.andios.kotlin.lambda

import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * @author lvsdian
 * Created on 2020-08-05
 */

// 带接受者的函数字面值
// kotlin提供了这样一种功能，可以通过指定的接受者对象来调用一个函数字面值
// 在函数字面值内部，你可以调用接受者对象的方法而无需使用任何额外的修饰符

fun main(args: Array<String>) {
    // "Int."表示函数接收者是Int类型，所以下面1可以调用subtract方法
    // "other: Int"表示另一个参数，它也是Int类型
    // "this" 表示调用subtract方法的那个对象
    // "-> Int" 表示返回类型是Int
    val subtract: Int.(other: Int) -> Int = { other -> this - other }
    println(1.subtract(3))

    println("------------------------")

    // 匿名函数可以让我们指定函数字面值的接受者类型，这样，我们就可以先去声明一个带有接收者的函数类型变量，然后去使用它
    val sum1 = fun Int.(other: Int): Int = this + other
    val sum2 = fun Int.(other: Int): Int { return this + other }
    println(1.sum1(2))
    println(1.sum2(2))

    println("------------------------")

    // 带有接收者类型的函数的非字面值可以作为参数进行传递，前提是所需要接收函数的地方应该有一个接收者类型的参数，反之亦然
    // 比如说：类型 String.(Int) -> Boolean 与 (String, Int) -> Boolean
    // 第一个表示由一个字符串来调用这个方法，接收一个Int型参数，返回Boolean,第二个表示函数接收两个参数，一个String，一个Int，返回Boolean，第二种方式
    // 相对于第一种方式，其实就是它的第一个参数String作为了函数的调用者
    var myEquals: String.(other: Int) -> Boolean = {other -> this.toIntOrNull() == other }
    println("456".myEquals(456)) //true

    // myTest函数接收4个参数，第一个op，类型为lambda表达式,接收一个String,一个Int，返回Boolean，第二个a,类型为Boolean，第三个b，类型为Int,第四个c,类型为Boolean
    // 函数实现为将a,b作为第一个参数op的参数，判断结果是否与c相等
    fun myTest(op: (String, Int) -> Boolean, a: String, b: Int, c: Boolean) = println(op(a ,b) == c)
    // 这里c为true，即判断op(a,b)是否为true
    myTest(myEquals, "200", 200, true)  //false
}
