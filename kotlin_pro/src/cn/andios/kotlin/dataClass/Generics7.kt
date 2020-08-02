package cn.andios.kotlin.dataClass

/**
 * @author lvsdian
 * Created on 2020-08-02
 */

// 泛型函数

fun <T> getValue(item: T): T {
    return item
}

fun main(args: Array<String>) {
    val item1 = getValue<Int>(3)
    println(item1)

    val item2 = getValue("hello")
    println(item2)



}

// 这种声明方式，表示T是List及List下面的类型，即List是T的上界
class UpperBoundsClass1<T: List<T>>{

}

// 这种声明方式，表示T有两个上界，一个是Any，一个是Comparable
class UpperBoundsClass2<T> where T: Comparable<T>, T: Any {

}
