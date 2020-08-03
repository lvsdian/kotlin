package cn.andios.kotlin.delegation

/**
 * @author lvsdian
 * Created on 2020-08-03
 */

// 委托(delegation)
// 原理：by关键字后面的对象实际上会被存储在类的内部，编译器则会将父接口中的所有方法实现出来，并且将实现转移给委托对象去进行

// 类委托
interface MyInterface {
    fun myPrint()
}

class MyInterfaceImpl(val str: String): MyInterface {
    override fun myPrint() {
        println("welcome $str")
    }
}

// myPrint方法的实现委托给构造参数myInterface来实现
// 如果MyClass本身也实现了myPrint()方法，同时又委托给myInterface去实现，那么就会采用MyClass本身的实现
class MyClass(myInterface: MyInterface): MyInterface by myInterface {
    override fun myPrint() {
        println("not welcome")
    }
}


fun main(args: Array<String>) {
    val myInterfaceImpl = MyInterfaceImpl("zhangsan")
    MyClass(myInterfaceImpl).myPrint()
}
