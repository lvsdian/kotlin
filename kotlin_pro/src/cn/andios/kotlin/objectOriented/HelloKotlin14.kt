package cn.andios.kotlin.objectOriented

/**
 * @author lvsdian
 * Created on 2020-07-31
 */
class MyExtensionProperty

// 属性也支持扩展
val MyExtensionProperty.name: String
    get() = "hello"

fun main(args: Array<String>) {
    var myExtensionProperty = MyExtensionProperty();
    println(myExtensionProperty.name)
}