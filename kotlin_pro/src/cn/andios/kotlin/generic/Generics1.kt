package cn.andios.kotlin.generic

/**
 * @author lvsdian
 * Created on 2020-08-01
 */
// generics：泛型，表示变量类型的参数化

class MyGeneric<T>(t: T) {
    var variable: T

    init {
        this.variable = t
    }
}

fun main(args: Array<String>) {
    // 完整写法
    var myGeneric1: MyGeneric<String> =
        MyGeneric<String>("hello")
    // 基于类型推断，简化
    var myGeneric2 = MyGeneric("hello")

    println(myGeneric1.variable)
    println(myGeneric2.variable)

    println("--------------------")

    var myClass = MyClass<String, Number>("myClass", 2)
    myTest(myClass)
}

// 协变（covariant)、逆变（contravariant）
// 协变：子类型转为父类型，out
// 逆变：父类型转为子类型，in
class MyClass<out T, in M>(t: T, m: M) {
    private var t: T
    private var m: M
    init {
        this.t = t
        this.m = m
    }

    fun get(): T = this.t

    fun set(m: M) {
        this.m = m
    }
}

fun myTest(myClass: MyClass<String, Number>) {
    // 要求String、Number类型，实际传的是Any、Int，MyClass中的in、out类似于java中的 ? super 和? extends
    var myObject: MyClass<Any, Int> = myClass
    println(myObject.get())
}
