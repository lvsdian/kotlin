// 如果不加下面这一行，编译后会生成"文件名+Kt.class"，即"AnnotationTest3Kt.class"
// 加了之后，会生成Annotation3.class
@file: JvmName("Annotation3")

package cn.andios.kotlin.annotation

fun main(args: Array<String>) {
    println("hello")
}