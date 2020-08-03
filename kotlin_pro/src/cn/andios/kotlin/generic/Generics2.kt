package cn.andios.kotlin.generic

import kotlin.test.assertTrue

/**
 * @author lvsdian
 * Created on 2020-08-01
 */
class ParameterizedClass<A>(private val value: A) {
    fun getValue(): A {
        return this.value
    }
}

class ParameterizedProducer<out T>(private val value: T) {
    fun get(): T {
        return this.value
    }
}

class ParameterizedConsumer<in T>{
    fun toString(value: T): String {
        return value.toString();
    }
}

fun main(args: Array<String>) {
    val parameterizedClass = ParameterizedClass<String>("hello")
    var result = parameterizedClass.getValue()

    assertTrue { result is String }

    println("----------------------")

    // 利用out将一个String类型协变为Any类型，即将子类型转为父类型，类似于Java中如下代码
    //List<String> lis1 = new ArrayList<>;
    //List<? extends Object> list2 = list1
    val parameterizedProducer = ParameterizedProducer("hello")
    val myRef1: ParameterizedProducer<Any> = parameterizedProducer

    assertTrue { myRef1 is ParameterizedProducer<Any> }

    println("---------------------")

    // 利用in将一个Number类型逆变为Int类型，即将父类型转为子类型，类似于Java中如下代码
    //List<Object> lis1 = new ArrayList<>;
    //List<? super String> list2 = list1
    val parameterizedConsumer = ParameterizedConsumer<Number>()
    var myRef2: ParameterizedConsumer<Int> = parameterizedConsumer

    assertTrue { myRef2 is ParameterizedConsumer<Int> }
}
