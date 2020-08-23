package cn.andios.kotlin.reflection

/**
 * @author lvsdian
 * Created on 2020-08-23
 */

// 属性引用(property reference)
// 属性引用的用法与参数引用的用法完全一致，都是通过::形式来引用
// 表达式 ::a表示类型KProperty<Int>的属性对象，我们可以通过get()来获取其值，也可以通过name属性来获取其名字
// 对于可变属性来说，比如说var b = 5,::返回的是类型KMutableProperty<Int>的值，它拥有一个set()


const val a = 3
var b = 3
fun main(args: Array<String>) {
    println(::a)        // val a: kotlin.Int
    println(::a.get())  // 3
    println(::a.name)   // a

    println("-------------------")

    ::b.set(10)
    println(::b)        // var b: kotlin.Int
    println(::b.get())  // 3
    println(::b.name)   // b
}
