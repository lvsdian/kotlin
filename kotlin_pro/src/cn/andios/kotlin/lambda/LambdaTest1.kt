package cn.andios.kotlin.lambda

/**
 * @author lvsdian
 * Created on 2020-08-03
 */

// 默认参数（default arguments）
fun test1(a: Int = 1, b: Int = 2) = println(a - b)

// 如果有默认值的参数位于其他没有默认值参数的前面，那么默认值只能通过在调用函数时使用具名参数的方式来使用
fun test2(a: Int = 1, b: Int) = println(a - b)

// 如果一个方法最后一个参数是一个lambda表达式，那么这个lambda表达式既可以作为参数传递，也可以直接放到{}里
fun test3(a:Int = 1, b:Int = 2, compute:(x: Int, y: Int) -> Unit) {
    compute(a, b)
}

// 具名参数：在调用函数时，函数参数可以是具名的，即指定参数名字
// 当一个函数有大量参数或者一些参数有默认值时，这种调用方式是比较方便的
// 在调用函数时，如果同时使用了位置参数与具名参数，那么所有的位置参数都必须位于第一个具名参数之前
// 比如说，foo(1, x = 3)是允许的，不过foo(x = 1,2)是不允许的
fun test4(a: Int, b:Int, c: Int, d: Int) = println(a + b + c + d)

// vararg：可变参数
fun test4(vararg strs: String) {
    println(strs.javaClass)
    strs.forEach { println(it) }
}

// kotlin中调用java方法时不能使用具名参数语法，因为java字节码并不总是会保留方法参数名信息
fun main(args: Array<String>) {
    test1()  // 不传参数，都取默认值
    test1(2) // 只传一个，默认就是第一个参数
    test1(b = 2) // 显示指定参数名
    test1(2, 3)

    println("-------------------")

    test2(b = 3) // 具名参数(named argument)

    println("--------------------")

    // 如果一个方法最后一个参数是一个lambda表达式，那么这个lambda表达式既可以作为参数传递，也可以直接放到{}里
    test3(1, 2, {a, b -> println(a + b)})
    test3(1, 2) { a, b -> println(a + b)}

    // 只传一个参数，默认传的是第一个参数
    test3(2) {
        a, b ->
        println(a - b)
    }
    // 不传参数，都取默认值
    // 如果函数的最后一个参数是lambda表达式，而且在调用时是位于圆括号之外，那么就可以不指定lambda表达式的具名参数名
    test3 {
            a, b ->
        println(a - b)
    }

    println("--------------------")

    test4(a = 1, b = 2, c = 3, d = 4)

    println("---------------------")

    test4("a", "b" ,"c")
    // *表示分散运算符，spread operator
    test4(strs = *arrayOf("a", "b", "c"))
    val arrays = arrayOf("1", "2", "3", "4")
    test4(*arrays)
}





// 对于重写的方法来说，子类所拥有的重写方法会使用与父类相同的默认参数值
// 在重写一个拥有默认参数值的方法时，方法签名中必须要将默认参数值省略掉
open class A {
    open fun method(a: Int, b: Int = 4) = a + b
}
class B: A() {
    override fun method(a: Int, b: Int) = a + b
}
