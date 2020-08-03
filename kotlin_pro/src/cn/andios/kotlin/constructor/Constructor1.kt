package cn.andios.kotlin.constructor

/**
 * @author lvsdian
 * Created on 2020-07-30
 */

// 在kotlin中，一个类可以有一个primary构造方法以及一个或多个secondary构造方法

// primary构造方法是类头的一部分，位于类名后面，可以拥有若干参数
// 如果primary构造方法的constructor关键字没有任何注解或是可见性关键字修饰，那么constructor关键字可省略
// primary构造方法不能包含任何代码，它对变量赋初值的功能由init代码块来完成
class MyClass constructor(username: String){

    private var user: String = username.toUpperCase();

    // init初始化代码块给类的成员变量赋初值，可直接访问构造方法的参数
    init {
        println(username)
        println(user)
    }
}

fun main(args: Array<String>) {
    var myClass = MyClass("Bob")
}