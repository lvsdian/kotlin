package cn.andios.kotlin.reflection

class MyTestClass13{
    var name: String = "okk"
    var price: Double = 11.1
}

var test = "test"

fun main(args: Array<String>) {
    val topProp = ::test
    topProp.set("after")

    println(topProp.get())      // after
    println(test)               // after

    val myTestClass13 = MyTestClass13()
    var name = MyTestClass13::name

    println(name)       // var cn.andios.kotlin.reflection.MyTestClass13.name: kotlin.String
    name.set(myTestClass13, "wdnmd")
    println(name.get(myTestClass13))        // wdnmd

    val prop = MyTestClass13::price
    println(prop.get(myTestClass13))        // 11.1
}