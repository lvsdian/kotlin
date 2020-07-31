package cn.andios.kotlin.demo

import java.lang.NumberFormatException

/**
 * @author lvsdian
 * Created on 2020-07-30
 */
fun main(args: Array<String>){
    println(convert2Int("111")) // 111
    println(convert2Int("abc")) // null
}

fun convert2Int(str: String): Int? {
    return try {
        str.toInt()
    }catch (ex: NumberFormatException) {
        // 如果这里直接返回null，会报错，因为我们期望是返回Int,null不是Int
        // 所以将返回值Int改为Int?，它表示返回结果可能为Int，也可能为null，否则表示结果一定为Int
        null;
    }
}

fun printMul1(str1: String, str2: String) {
    var a = convert2Int(str1)
    var b = convert2Int(str2)
    // 这里a,b未进行验证，是Int?类型，相乘就报错
    //println(a * b)
}

fun printMul2(str1: String, str2: String) {
    var a = convert2Int(str1)
    var b = convert2Int(str2)
    // 这里经过了非空判断，kotlin智能的将a,b变为Int类型，可以相乘
    if (null == a) {
        println("param not int")
    } else if (null == b) {
        println("param not int")
    } else {
        println(a * b)
    }
}