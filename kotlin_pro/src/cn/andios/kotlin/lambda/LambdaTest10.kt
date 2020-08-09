package cn.andios.kotlin.lambda

/**
 * @author lvsdian
 * Created on 2020-08-05
 */

// 解构----将对象的属性拆开

data class MyResult(val result: String, val status: Int)

fun myMethod1(): MyResult {
    return MyResult("success", 1)
}

fun myMethod2(): Pair<String, Int> {
    return Pair("fail", 2)
}

fun main(args: Array<String>) {
    val (result1, status1) = myMethod1()
    println(result1)  // success
    println(status1)  // 1

    println("---------------------")

    val (result2, status2) = myMethod2()
    println(result2)  // fail
    println(status2)  // 2

    println("----------------------")

    // a to b：a为key,b为value
    val map = mapOf<String, String>("a" to "aa", "b" to "bb")
    println("遍历方式一：")
    for((key: String, value: String) in map) {
        println("key: $key, value: $value")
    }

    println("----------------------")

    println("遍历方式二：")
    // mapValues方法表示key不变，对value做一个映射（保证key不变，只改value）
    // 这里的entry就表示map中的每一个键值对,取出每个键值对中的value，将value改为$value + x，然后打印每个entry（it表示每个entry）
    map.mapValues { entry -> "${entry.value}x" }.forEach{ println(it) }  // a=aax     b=bbx
    // 这里的entry就表示map中的每一个键值对,取出每个键值对中的value，将value改为$key + x，然后打印每个entry（it表示每个entry）
    map.mapValues { entry -> "${entry.key}x" }.forEach{ println(it) }    // a=ax      b=bx

    println("----------------------")

    println("遍历方式三：")
    // mapKeys方法表示value不变，对key做一个映射（保证value不变，只改key）
    // 这里的entry就表示map中的每一个键值对,取出每个键值对中的key，将key改为$key + y，然后打印每个entry（it表示每个entry）
    map.mapKeys { entry -> "${entry.key}y" }.forEach{ println(it) }     // ay=aa        by=bb
    // 这里的entry就表示map中的每一个键值对,取出每个键值对中的key，将key改为$value + y，然后打印每个entry（it表示每个entry）
    map.mapKeys { entry -> "${entry.value}y" }.forEach{ println(it) }   // aay=aa       bby=bb

    println("----------------------")

    println("遍历方式四：")
    map.mapValues { (_, value) -> value }.forEach { println(it) }

    println("----------------------")

    println("遍历方式五：")
    map.mapKeys { (key, _) -> key }.forEach { println(it) }

    println("----------------------")

    println("遍历方式六：")
    // a=aa     b=bb
    map.forEach { println(it) }

    println("----------------------")

    // kotlin允许我们为结构声明整体指定类型，也可以为每一个具体的component指定类型
    // Map.Entry<String, String>为解构声明整体的类型
    map.mapValues { (key, value): Map.Entry<String, String> -> "$key + $value" }.forEach { println(it) }
    // String表示每个具体component的类型
    map.mapValues { (key: String, value: String) -> "$key + $value" }.forEach { println(it) }
}
