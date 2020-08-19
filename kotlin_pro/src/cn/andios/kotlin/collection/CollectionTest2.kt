package cn.andios.kotlin.collection

/**
 * @author lvsdian
 * Created on 2020-08-16
 */



fun main(args: Array<String>) {
    val items = listOf(1, 2, 3, 4)

    println(items.first())
    println(items.last())
    items.filter { it % 2 == 0 }.forEach { println(it) }

    println(items.requireNoNulls()) // [1, 2, 3, 4]

    println(items.none { it > 10 }) // true

    println(items.firstOrNull()) // 1

    println("-----------------------")

    val myMap1 = hashMapOf("hello" to 1, "world" to 2)
    val myMap2: Map<String, Int> = HashMap(myMap1)

    println(myMap2) // {hello=1, world=2}



}
