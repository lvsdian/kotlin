package cn.andios.kotlin.objectOriented

/**
 * @author lvsdian
 * Created on 2020-07-31
 */

interface A {
    // kotlin中接口可以只有声明，也可以有实现
    fun method() {
        println("A")
    }
}

open class B {
    open fun method() {
        println("B")
    }
}

// 类C同时实现接口A、继承类B，A、B中都有method方法，所以这里强制重写method方法
class C:A, B() {
    override fun method() {
        super<A>.method()
        super<B>.method()
        println("C")
    }
}

fun main(args: Array<String>) {
    var c = C();
    c.method()
}