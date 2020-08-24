package cn.andios.kotlin.reflection

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredMemberProperties

class MyTestClass12{
    var name: String = "okk"
    var price: Double = 11.1
}

fun main(args: Array<String>) {
    val clazz = MyTestClass12::class
    val instance = clazz.createInstance()
    val prop = clazz.declaredMemberProperties

    prop.forEach {
        when (it.name) {
            "name" -> {
                val kmp = it as KMutableProperty1<MyTestClass12, Any>
                kmp.set(instance, "ha")
                println(it.get(instance))       // ha
            }
            "price" -> {
                println(it.get(instance))       // 11.1
            }
        }
    }

}