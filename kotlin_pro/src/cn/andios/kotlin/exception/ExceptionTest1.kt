package cn.andios.kotlin.exception

import javax.xml.bind.DatatypeConverter.parseInt

/**
 * @author lvsdian
 * Created on 2020-08-16
 */

// 异常，kotlin中的try是个表达式
// kotlin中没有checked exception

fun main(args: Array<String>) {
    val s = "s"
    val result: Int? = try {
        parseInt(s)
    }catch (ex: NumberFormatException) {
        null
    } finally {
        println("finally")
    }
    println(result)
}
