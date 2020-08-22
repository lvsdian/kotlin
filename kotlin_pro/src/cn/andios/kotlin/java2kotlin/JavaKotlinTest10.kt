package cn.andios.kotlin.java2kotlin

/**
 * @author lvsdian
 * Created on 2020-08-22
 */

class Test10 @JvmOverloads constructor(x: Int = 1, y: String = "hello", z: Double) {
    fun myMethod(a: Int, b: String, c: Int = 2) {
        println("a:$a,b:$b,c:$c")
    }
}
