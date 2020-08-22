package cn.andios.kotlin.java2kotlin

/**
 * @author lvsdian
 * Created on 2020-08-22
 */

// 在kotlin中，我们可以将具名对象或是伴生对象中定义的函数注解为@JvmStatic，
// 这样编译器既会在相应对象的类中生成静态方法，也会在对象自身中生成静态方法
class Test7 {
    companion object {
        fun test1() {
            println("test1")
        }

        @JvmStatic
        fun test2() {
            println("test2")
        }
    }
}
