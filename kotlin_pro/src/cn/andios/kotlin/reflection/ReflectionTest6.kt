package cn.andios.kotlin.reflection

// 要访问一个类中的成员属性，需要使用全限定名称

fun main(args: Array<String>) {
    val values = listOf("how", "what", "which")
    println(values.map(String::length))     // [3, 4, 5]

    println("--------------------")

    val x = MyClass::x
    println(x)      // val cn.andios.kotlin.reflection.MyClass.x: kotlin.Int
    println(x.get(MyClass(10)))     // 10

}
class MyClass (val x: Int) {

}