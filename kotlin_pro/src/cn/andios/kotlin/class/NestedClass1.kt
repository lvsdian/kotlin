package cn.andios.kotlin.`class`

/**
 * @author lvsdian
 * Created on 2020-08-02
 */

// 嵌套类、内部类之间的区别于联系
// 1.嵌套类：对应于java的静态内部类（即由static关键字修饰的内部类），只要在一个类的内部定义了另外一个类，那么这个类就叫做嵌套类，
//      相当于java中有static关键字修饰的内部类
// 2.内部类：对应于java中的非静态内部类（即没有static关键字修饰的内部类），使用inner关键字在一个类的内部所定义的另外一个类就叫做内部类，
//      相当于java中没有static关键字修饰的内部类

// 嵌套类：Nested Class
// 由如上，嵌套类不能访问外部类，只能访问另外一个嵌套类（因为嵌套类是静态的）
class OuterClass1 {
    private val str: String = "hello"

    class NestedClass1 {
        fun nestedMethod() = "welcome"
    }

    // 访问另外一个嵌套类
    class NestedClass2 {
        var nestedClass = NestedClass1()
    }
}

fun main(args: Array<String>) {
    println(OuterClass1.NestedClass1().nestedMethod())
}
