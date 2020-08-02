package cn.andios.kotlin.base

/**
 * @author lvsdian
 * Created on 2020-07-30
 */
fun main(args: Array<String>){
    println(convert2Uppercase("hello world"))
    println(convert2Uppercase(23))
}

/**
 * Any表示任意类型，类似于java中java.lang.Object
 * 任意一个类型都能传进来，返回值为String或null
 */
fun convert2Uppercase(str: Any): String? {
    if (str is String) {
        return str.toUpperCase()
    }
    return null
}