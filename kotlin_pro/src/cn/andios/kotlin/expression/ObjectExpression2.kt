package cn.andios.kotlin.expression

/**
 * @author lvsdian
 * Created on 2020-08-02
 */


// 匿名对象只能在局部变量范围内或是被private修饰的成员变量范围内（重要：即在方法内部声明或者是在类中声明但必须被private修饰）才能被识别出来其真正的类型
// 如果将匿名对象当做一个public方法的返回类型或是public属性的类型，那么该方法或是属性的真正类型就是该匿名对象所声明的父类型，
// 如果没有声明任何父类型，那么其类型就是Any；
// 这种情况下，匿名对象中所声明的任何成员都是无法访问的
class MyClass1 {
    // 如果这里不用private修饰，那么myObject的类型就是它的父类型，这里没用声明父类型，就会当做Any类型，此时，这里的output()方法其他地方是无法访问的
    private var myObject = object {
        fun output() {
            println("output invoked")
        }
    }
    fun myTest() {
        // 打印myObject的类型
        println(myObject.javaClass)
        println(myObject::class.java)

        myObject.output()
    }
}

class MyClass2 {
    // 这里在类中声明，用了private修饰，所以可以识别为对象表达式
    private fun method1() = object {
        var str = "hello"
    }

    // 这里在类中声明，但用的internal修饰，所以不会识别为对象表达式，而是识别为Any类型
    internal fun method2() = object {
        var str = "world"
    }

    fun test() {
        // 对象表达式，所以可以访问到str
        val str1 = method1().str
        // 非对象表达式，识别到的是Any类型，所以不能访问str
        val str2 = method2()
    }
}

fun main(args: Array<String>) {
    var myClass = MyClass1()
    myClass.myTest()
}
