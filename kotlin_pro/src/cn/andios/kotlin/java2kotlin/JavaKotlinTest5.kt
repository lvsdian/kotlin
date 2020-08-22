@file:JvmName("JavaKotlinTest5")


package cn.andios.kotlin.java2kotlin

/**
 * @author lvsdian
 * Created on 2020-08-22
 */

var name: String = "zhangsan"

// 使用@JvmField注解对kotlin中的属性进行标注时，表示他是一个实例字段（instance field），kotlin编译器在处理时，
// 将不会给这个字段生成getter/setter
@JvmField
var age: Int = 10
