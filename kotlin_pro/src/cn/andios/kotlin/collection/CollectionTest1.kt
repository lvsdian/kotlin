package cn.andios.kotlin.collection

/**
 * @author lvsdian
 * Created on 2020-08-16
 */
// kotlin严格区分可变集合与不可变集合
// 要清楚的一点是：区分开可变集合的只读视图和与实际上真正的不可变集合

fun main(args: Array<String>) {
    val stringList: MutableList<String> = mutableListOf("hello", "world", "welcome")
    // 指定类型为List<String>，表示一个不可变集合
    val readOnlyView1: List<String> = stringList
    // 不指定类型，默认就是MutableList<String>，表示一个可变集合
    val readOnlyView2 = stringList

    println("stringList:$stringList") //stringList:[hello, world, welcome]

    stringList.add("woc")

    println("readOnlyView1:$readOnlyView1") //readOnlyView1:[hello, world, welcome, woc]
    println("stringList:$stringList") //stringList:[hello, world, welcome, woc]

    // 不可变集合只能读
    readOnlyView1[0]
    // 可变集合可以写
    readOnlyView2.add("ii")

    println("-------------------------")

    val strings: HashSet<String> = hashSetOf("a", "b", "c", "d")
    println(strings.size)

    println("------------------------")

    // 只读类型是协变的，因为它只用于从集合中获取数据，而不会修改集合中的数据
    val s1 = listOf("a", "b")
    val s2: List<Any> = s1

    println("------------------------")

    // 快照
    // toList扩展方法只是复制原集合中的元素，所以返回的集合就可以确保不会发生变化
    val items1 = mutableListOf("a", "b", "c")
    val items2 = items1.toList()

    items1.add("d")

    println("items1:$items1") //items1:[a, b, c, d]
    println("items2:$items2") //items2:[a, b, c]

}
