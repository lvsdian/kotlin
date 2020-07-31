package cn.andios.kotlin.objectOriented

/**
 * @author lvsdian
 * Created on 2020-07-31
 */

/*
    扩展作用域
        1. 扩展函数所定义在的类实例叫做分发接收者（dispatch receiver）
        2. 扩展函数所扩展的那个类的实例叫做扩展接收者（extension receiver）
        3. 当以上两个名字出现冲突时，扩展接收者的优先级最高
 */

class DD {
    fun method1() {
        println("DD method")
    }
}

class EE {
    fun method2() {
        println("EE method")
    }

    // 在EE类中对DD进行扩展，在这个扩展中，可以使用DD已经有的方法，也可以使用定义这个扩展函数所在的类中的方法
    // DD是扩展接收者，EE是分发接收者
    fun DD.hello() {
        method1()
        method2()
    }

    // EE这个分发接收者中可以正常使用DD的扩展方法hello()
    fun world(dd: DD) {
        dd.hello()
    }

    // output这个扩展方法中，调用toString()方法，而DD、EE都有toString()方法，根据上述第三点，扩展接收者的优先级最高
    // DD优先级 > EE优先级，所以是调用的DD的toString()方法，如果想调用EE的toString()方法，需要写成this@EE.toString()
    fun DD.output() {
        println(toString())
        println(this@EE.toString())
    }

    // DD的两个扩展方法hello()和output()是在EE中定义的，所以只能在EE中访问，其他地方（比如EE外面的main()方法中）无法访问
    fun test() {
        var dd = DD()
        dd.output()
    }
}

fun main(args: Array<String>) {
    EE().test()
}