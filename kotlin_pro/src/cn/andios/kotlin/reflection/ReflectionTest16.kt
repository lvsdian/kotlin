package cn.andios.kotlin.reflection

class MyTestClass4(value: Int) {
    constructor(amount: Int, color: String): this(amount) {
        println("secondary constructor")
    }

    constructor(amount: Int, full: Boolean): this(amount) {
        println("secondary constructor")
    }

    fun printSomething() {
        println("something")
    }
}

fun main(args: Array<String>) {
    val myTestClass4 = MyTestClass4::class
    val constructors = myTestClass4.constructors
    // [fun <init>(kotlin.Int, kotlin.String): cn.andios.kotlin.reflection.MyTestClass4, fun <init>(kotlin.Int, kotlin.Boolean): cn.andios.kotlin.reflection.MyTestClass4, fun <init>(kotlin.Int): cn.andios.kotlin.reflection.MyTestClass4]
    println(constructors)
}
