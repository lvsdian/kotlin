package cn.andios.kotlin.`class`

/**
 * @author lvsdian
 * Created on 2020-08-02
 */

class OuterClass4 {
    inner class InnerClass4(str: String) {
        init {
            println(str)
        }
    }
}

fun main(args: Array<String>) {
    // 外部类外面声明内部类对象
    var innerClass4: OuterClass4.InnerClass4 = OuterClass4().InnerClass4("hello")
}
