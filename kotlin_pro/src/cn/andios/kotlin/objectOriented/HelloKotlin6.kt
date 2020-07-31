package cn.andios.kotlin.objectOriented

/**
 * @author lvsdian
 * Created on 2020-07-31
 */
open class MyParent1 {
    // 属性被重写，也要加open关键字
    open val username: String = "parent"
}
class MyChild1: MyParent1() {
    // 重写父类属性，也要加override关键字
    override val username: String = "child"
}

// 上面MyChild1是在类中重写父类username属性
// 也可以在primary constructor中重写父类属性
class MyChild2(override val username: String): MyParent1() {

}


// val 可以 override val
// var 可以 override var
// val 不能 override var
// var 可以 override val

// 本质上，val相当于get方法，只能读
// var相当于get、set可读可写，

open class MyParent3 {
    open fun method() {
        println("parent method")
    }
    open val name: String = ""
}

class MyChild3: MyParent3() {
    override fun method() {
        super.method()
        println("child method")
    }
    override var name: String = ""
        get() = super.name + "and child"
}

fun main(args: Array<String>) {
    val myChild1 = MyChild1();
    println(myChild1.username)

    println("----------------------------")

    val myChild3 = MyChild3();
    myChild3.method()
    println(myChild3.name)
}