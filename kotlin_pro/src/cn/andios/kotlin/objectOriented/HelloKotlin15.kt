package cn.andios.kotlin.objectOriented

/**
 * @author lvsdian
 * Created on 2020-07-31
 */

class CompanionObjectExtension {
    companion object MyObject{

    }
}

// 扩展伴生对象
fun CompanionObjectExtension.MyObject.method() {
    println("扩展伴生对象")
}

fun main(args: Array<String>) {
    CompanionObjectExtension.method()
}