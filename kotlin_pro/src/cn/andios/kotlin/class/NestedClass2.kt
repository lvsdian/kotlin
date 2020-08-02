package cn.andios.kotlin.`class`

/**
 * @author lvsdian
 * Created on 2020-08-02
 */

class OuterClass3 {
    class NestedClass3 {
        init {
            println("NestedClass3构造块执行")
        }
    }
}

fun main(args: Array<String>) {
    // 外部类的外面声明嵌套类的对象
    val nestedClass3: OuterClass3.NestedClass3 = OuterClass3.NestedClass3()
}
