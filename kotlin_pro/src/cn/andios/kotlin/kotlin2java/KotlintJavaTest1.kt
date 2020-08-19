package cn.andios.kotlin.kotlin2java

/**
 * @author lvsdian
 * Created on 2020-08-19
 */

fun main(args: Array<String>) {
    val list = ArrayList<String>()

    list.add("hello")
    list.add("world")

    for (i in 0 until list.size) {
        println(list[i])
    }

    println("----------------------------")

    var person = Person()
    person.age = 20
    person.isMarried = false
    person.name =
}
