package cn.andios.kotlin.objectOriented

/**
 * @author lvsdian
 * Created on 2020-07-31
 */

class ExtensionTest {
    fun add(a: Int, b: Int) = a + b
    fun subtract(a: Int, b: Int) = a -b
}

// 扩展函数
// Extension只有add、subtract方法，通过如下可以将ExtensionTest新增一个multiply方法
fun ExtensionTest.multiply(a: Int, b: Int) = a * b

fun main(args: Array<String>) {
    var extensionTest = ExtensionTest();

    println(extensionTest.add(1, 2))
    println(extensionTest.subtract(1, 2))
    println(extensionTest.multiply(1, 2))

    println("-------------------------")

    // 这里运行结果都是a，因为myPrint方法声明的类型为AA类型，所以就算传入BB类型，也是调用AA类型的a()方法
    myPrint(AA())
    myPrint(BB())

    println("-------------------------")

    // CC类中已经有一个foo方法，再给它扩展一个foo方法，最终调用的是原来的foo方法
    // 扩展函数支持重载，比如原本的foo方法无参，扩展的foo有参，那么实际调用根据是否传参数来区分
    CC().foo() // foo1


}

// 扩展函数的解析是静态分发的，不是动态的，即不支持多态，调用只取决于对象的声明类型
// 扩展函数并不会将扩展的方法插入到既有的类中，即不会真正修改目标类
// 调用是由对象声明类型所决定的，而不是由对象的实际类型所决定的


// BB继承AA这个类，AA、BB分别有一个扩展方法a()
open class AA
class BB: AA()

fun AA.a() = "a"
fun BB.a() = "b"

// 注意，这里aa为AA类型，调用使用对象声明类型所决定的，就算传入BB类型，调用的也是AA类型的a()方法
fun myPrint(aa: AA) {
    println(aa.a())
}


class CC {
    fun foo(){
        println("foo1")
    }
}
fun CC.foo() {
    println("foo2")
}