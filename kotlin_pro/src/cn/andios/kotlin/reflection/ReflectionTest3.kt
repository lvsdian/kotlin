package cn.andios.kotlin.reflection

/**
 * @author lvsdian
 * Created on 2020-08-23
 */


// 方法引用
// 支持重载
// ::multiplyBy3表示函数类型 (Int) -> Int 的值
fun multiplyBy3(x: Int): Int {
    return 3 * x
}

fun multiplyBy3(s: String): Int {
    return 10
}

fun main(args: Array<String>) {
    val values1 = listOf(1, 2, 3, 4)
    // 方式一
    println(values1.map { multiplyBy3(it) }.forEach { println(it) })
    // 方式二，multiplyBy3是个包级别函数，所以直接用 ::
    println(values1.map( ::multiplyBy3 ).forEach { println(it) })

    println("------------------------")

    val values2 = listOf("a", "b", "c", "d")
    println(values2.map(::multiplyBy3 ).forEach { println(it) })
}

// 会自动进行类型推断
val myReference1: (Int) -> Int = ::multiplyBy3
val myReference2: (String) -> Int = ::multiplyBy3
val myReference3: String.(Int) -> Char = String::get
