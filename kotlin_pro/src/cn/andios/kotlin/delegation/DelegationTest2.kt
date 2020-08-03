package cn.andios.kotlin.delegation

import kotlin.reflect.KProperty

/**
 * @author lvsdian
 * Created on 2020-08-03
 */

// 委托属性(delegated property)
// 如下4种情况比较有用
//  1.延迟属性：第一次访问时会计算，第二次访问取第一次缓存的结果
//  2.可观测属性：给一个属性赋值时，在赋值之前或赋值之后进行一些处理
//  3.非空属性
//  4.map属性


// 对于属性委托的要求：
//  对于只读属性来说(val修饰的属性)，委托需要提供一个名为getValue的方法，该方法接收如下参数：
//  - thisRef，需要是属性拥有者的类型或是其父类型(对于扩展属性来说，这个类型指的是被扩展的那个类型)
//  - property,需要是KProperty<*>类型或是其父类型
//  getValue需要返回属性相同的类型或是其子类型
//  对于可变属性来说(var修饰的属性)，委托需要再提供一个名为setValue的方法，该方法需要接收如下参数：
//  - thisRef,与getValue方法的thisRef要求一致
//  - property,与getValue方法的property要求一致
//  - newValue，需要与属性的类型相同或是父类型
//  getValue与setValue既可以作为委托类的成员方法实现，也可以作为扩展方法来实现
//  这两个方法都必须标记为operator关键字，对于委托类来说，它可以实现ReadOnlyProperty或是ReadWriteProperty接口，这些接口包含了相应的getValue
//  与setValue方法;同时，对于委托类来说，也可以不去实现这两个接口，而是自己单独实现相应的getValue与setValue方法
class MyDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String = "$thisRef,your delegated property name is ${property.name}"

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) = println("$thisRef, new value is $value")
}

class MyPropertyClass {
    var str: String by MyDelegate()
}

fun main(args: Array<String>) {
    val myPropertyClass = MyPropertyClass()

    myPropertyClass.str = "hello world"
    println(myPropertyClass.str)
}
