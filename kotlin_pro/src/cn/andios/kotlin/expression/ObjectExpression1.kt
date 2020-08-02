package cn.andios.kotlin.expression

/**
 * @author lvsdian
 * Created on 2020-08-02
 */

// 对象表达式（object expression）
// java中匿名内部类在很多场景下都得到了大量使用
// kotlin的对象表达式就是为了解决匿名内部类的一些缺陷而产生的
//  1.匿名内部类是没有名字的类
//  2.匿名内部类一定是继承了某个父类，或者是实现了某个接口
//  3.java运行时会将该匿名内部类当做它所实现的接口或是所继承的父类来看待

/*
    对象表达式格式：
        object [:若干个父类型，中间用,分割] {

        }
 */

interface MyInterface {
    fun printMyInterfaceInfo(i: Int)
}
abstract class MyAbstractClass {
    abstract val age: Int
    abstract fun printMyAbstractClassInfo()
}

fun main(args: Array<String>) {

    // 这里的对象表达式，类似于java中的匿名内部类，这个内部类实现了MyInterface接口
    var myObject1 = object: MyInterface {
        override fun printMyInterfaceInfo(i: Int) {
            println("i的值是$i")
        }
    }
    myObject1.printMyInterfaceInfo(100)

    println("-------------------------")

    // 未实现接口、未继承父类的对象表达式
    var myObject2 = object {
        init {
            println("初始化块执行")
        }
        var myProperty = "hello"

        fun myMethod() = "myMethod()"
    }
    println(myObject2.myProperty)
    println(myObject2.myMethod())

    println("------------------------")

    // 同时实现接口、继承父类的对象表达式
    var myObject3 = object: MyInterface, MyAbstractClass() {
        override fun printMyInterfaceInfo(i: Int) {
            println("i的值是$i")
        }

        override val age: Int
            get() = 30

        override fun printMyAbstractClassInfo() {
            println("printMyAbstractClassInfo invoked")
        }
    }
    myObject3.printMyInterfaceInfo(100)
    println(myObject3.age)
    myObject3.printMyAbstractClassInfo()
}
