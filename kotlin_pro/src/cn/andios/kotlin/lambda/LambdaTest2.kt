package cn.andios.kotlin.lambda

/**
 * @author lvsdian
 * Created on 2020-08-05
 */

// Unit表示无返回值，Unit也可以省略掉
fun myPrint(name: String): Unit {
    println(name)
}

// 但表达式函数，函数的返回类型如果可以通过类型推断判断出来，那么返回类型就可以省略掉,
// 这里Int类型的返回值可以省掉
fun add(a: Int, b: Int): Int = a + b

// 显式返回类型
// 拥有方法体的函数必须要显式指定返回类型
// 这里返回类型不能省掉
// Kotlin并不会推断拥有块体的函数的返回类型，因为这种函数可能拥有非常复杂的控制流程，返回类型对于阅读代码的人来说不是那么明显了（有时，对于编译器也如此）
fun add(a: Int, b: Int, c: Int): Int {
    return a + b + c
}


// 一个方法中，只允许一个参数为vararg，通常作为最后一个参数。如果vararg不是最后一个参数，那么其后的参数就需要通过具名参数形式进行传递；如果其后的参数是函数类型，
// 那么还可以通过再圆括号外传递lambda表达式来实现

fun <T> convert2List(vararg elements: T): List<T> {
    val result = ArrayList<T>()

    elements.forEach { result.add(it) }
    return result
}

fun main(args: Array<String>) {
    println(convert2List("11", "22", "33", "44"))
}
