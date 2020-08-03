package cn.andios.kotlin.delegation

import java.util.*

/**
 * @author lvsdian
 * Created on 2020-08-03
 */
// map委托
// 将属性存储到map中
// 一种常见的应用场景是将属性值存储到map当中，这通常出现在json解析或是一些动态行为
// 这种情况中，你可以将map实例作为类中属性的委托

// map中key的名字要与类中的属性名字保持一致
class Student1(map: Map<String, Any?>) {
    val name: String by map
    val address: String by map
    val age: Int by map
    val birthday: Date by map
}

class Student2(map: MutableMap<String, Any?> ) {
    var address: String by map
}

fun main(args: Array<String>) {
    val student1 = Student1(mapOf(
        "name" to "zhangsan",
        "address" to "shanghai",
        "age" to 20,
        "birthday" to Date()
    ))
    println(student1.toString())

    println("------------------")

    val map: MutableMap<String, Any?> = mutableMapOf(
        "address" to "nanjing"
    )
    val student2 = Student2(map)
    println(map["address"]) // nanjing
    println(student2.address) //nanjing

    println("----------------")

    // student2的属性是由map来维护的，所以这里map的内容也会被修改
    student2.address = "taiwan"
    println(map["address"]) // taiwan
    println(student2.address) //taiwan
}
