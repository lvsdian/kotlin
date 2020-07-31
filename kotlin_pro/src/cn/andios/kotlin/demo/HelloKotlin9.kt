package cn.andios.kotlin.demo

/**
 * @author lvsdian
 * Created on 2020-07-30
 */
fun main(args: Array<String>) {
    // length > 5  toUpperCast sort  print
    var list = listOf<String>("hello", "world", "good")

    when {
        "world" in list -> println("world in list")
    }

    list.filter {
            it.length > 5
        }
        .map {
            it.toUpperCase()
        }
        .sorted()
        .forEach{
            println(it)
        }
}