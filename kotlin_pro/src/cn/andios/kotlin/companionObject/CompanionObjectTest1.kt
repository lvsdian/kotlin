package cn.andios.kotlin.companionObject

import cn.andios.kotlin.objectDeclaration.ObjectDemo

/**
 * @author lvsdian
 * Created on 2020-08-03
 */

// companion object:伴生对象
// java中的静态方法，鼓励通过类名来直接调用，虽说也可以通过实例来调用
// 在kotlin中类是没有static方法的，在大多数情况下，kotlin推荐的做法是使用包级别的函数来作为静态方法
// kotlin会将包级别的函数当作静态方法来看待

// MyTest中有一个伴生对象MyObject，它随着MyTest的存在而存在
class MyTest {
    // 这个伴生对象的名字MyObject可以省略
    // 每个类只能有一个伴生对象
    companion object MyObject {
        var a: Int = 100
        fun method() {
            println("method invoked")
        }
    }
}

fun main(args: Array<String>) {

    // 伴生对象
    // 访问伴生对象的方法和属性
    MyTest.method()
    println(MyTest.a)

    println("---------------")

    // 虽然伴生对象的成员来起来像是java中的静态成员，但在运行期，他们依旧是真实对象的实例成员
    // 比如这里，伴生对象MyObject其实是MyTest的静态内部类，即MyTest.method()相当于访问MyTest的静态内部类MyObject的静态方法method()
    // 在JVM上，可以将伴生对象的成员真正生成为类的静态方法与属性，通过@JvmStatic注解来实现
    // 即如果给伴生对象MyObject的method方法加一个@JvmStatic注解，那么method方法就变成了MyTest的静态方法,
    // 即MyTest.method()相当于访问MyTest自己的静态方法method()

    // 访问伴生对象的方法和属性
    MyTest.method() // 这种调用伴生对象的方式，类似于调用静态方法，
    println(MyTest.a) // 这种调用伴生对象的方式，类似于调用静态属性
}
