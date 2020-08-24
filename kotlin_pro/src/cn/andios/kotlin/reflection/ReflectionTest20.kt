package cn.andios.kotlin.reflection

import kotlin.reflect.full.companionObject

class MyTestClass8 {
    companion object {
        fun method() {
            println("hello")
        }
    }
}

fun main(args: Array<String>) {
    var myTestClass8 = MyTestClass8::class
    var companionObj = myTestClass8.companionObject

    println(companionObj)      // class cn.andios.kotlin.reflection.MyTestClass8$Companion
    MyTestClass8.method()


}