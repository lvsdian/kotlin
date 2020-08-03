package cn.andios.kotlin.generic

import kotlin.test.assertTrue

/**
 * @author lvsdian
 * Created on 2020-08-02
 */


// use-site variance(type projection), 类型投影


// 数组的浅拷贝
fun copy(from: Array<out Any>, to: Array<Any>) {
    assertTrue { from.size == to.size }

    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun main(args: Array<String>) {
    val from: Array<Int> = arrayOf(1, 2, 3, 4)
    val to: Array<Any> = arrayOf(1, 2, 3, 4)

    // 如果copy函数中from类型不加out，这里就会报错
    // 加上out就表示类型投影，限制了我们在copy函数中只能调用from返回这个泛型的方法（读方法），
    // 不能调用写入这个方法的泛型的方法（写方法），比如`from[0]=1`就会报错
    // 加上out后，即不允许在copy函数中修改from，那么main函数中的from执行copy函数就是安全的，保证它始终是Int类型
    copy(from, to)

    println("----------------------------")

    val array1: Array<String> = Array<String>(4) { _->"hello"}

    setValue(array1, 1, "world")

    val array2: Array<Any> = Array<Any>(4) { it -> "hello$it" }

    // 如果setValue函数中to类型不加in，这里就会报错
    // 加上in就相当于Java的`? super String`，所以加上后传入Any类型就不会报错
    setValue(array2, 2, "welcome")
}

fun setValue(to: Array<in String>, index: Int, value: String) {
    to[index] = value
}
