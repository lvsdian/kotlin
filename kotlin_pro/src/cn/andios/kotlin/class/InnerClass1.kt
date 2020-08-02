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

// 内部类（Inner Class）
class OuterClass2{
    private var str: String = "hello"

    // 相较于NestedClass，多了一个inner关键字
    inner class InterClass {
        // 内部类中访问外部类的成员，需要this@xxx
        fun innerMethod() = this@OuterClass2.str
    }

    // 局部嵌套类--在方法内部定义的类
    fun getName(): String {
        class LocalNestedClass {
            val name: String = "myLocalNestedClass"
        }
        var localNestedClass = LocalNestedClass()
        return localNestedClass.name
    }
}

fun main(args: Array<String>) {
    // 调用是OuterClass()，不是OuterClass2，这里也与NestedClass有区别
    // 因为NestedClass相当于java静态内部类，InnerClass相当于java的非静态内部类
    println(OuterClass2().InterClass().innerMethod())

    println("--------------")

    println(OuterClass2().getName())
}
