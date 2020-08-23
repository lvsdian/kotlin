package cn.andios.kotlin.reflection

// 扩展属性

val String.firstChar: Char
    get() = this[0]


fun main(args: Array<String>) {
    val s = "xyz"
    println(s.firstChar)                // x
    println(String::firstChar)          // val kotlin.String.firstChar: kotlin.Char
    println(String::firstChar.get(s))   // x
}