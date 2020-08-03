package cn.andios.kotlin.delegation

import kotlin.properties.Delegates

/**
 * @author lvsdian
 * Created on 2020-08-03
 */

// 非空属性

// notNull适用于无法在初始化阶段就确定属性值的场合
class MyPerson {
    var address: String by Delegates.notNull<String>()
}

fun main(args: Array<String>) {
    val myPerson = MyPerson()

    // 在访问前必须进行赋值，否则会报错：java.lang.IllegalStateException: Property address should be initialized before get.
    myPerson.address = "suzhou"
    println(myPerson.address)
}
