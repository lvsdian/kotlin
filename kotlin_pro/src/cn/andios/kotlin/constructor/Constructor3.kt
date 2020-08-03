package cn.andios.kotlin.constructor

/**
 * @author lvsdian
 * Created on 2020-07-31
 */

// 这里的username是构造方法参数，前面没有var或val
// age,address是类的属性
class Student1 (username: String, private val age: Int, private var address: String) {

    fun printInfo() {
        println("age: $age, address: $address")
    }
}

/**
 * 在JVM上，如果类的primary构造方法的所有参数都拥有默认值，那么kotlin编译器就会为这个类生成一个不带参数的构造方法，
 * 这个不带参数的构造方法会使用这些参数的默认值，这样做的目的在于可以跟Spring等框架更好的集成
 */
class Student2 (val username: String = "zhangsan") {

}

fun main(args: Array<String>) {
    val student = Student1("zhangsan", 20, "shanzhen")
    student.printInfo()

    var student2 = Student2()
    println(student2.username)

    student2 = Student2("lisi")
    println(student2.username)
}