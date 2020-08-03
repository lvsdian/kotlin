package cn.andios.kotlin.delegation

import cn.andios.kotlin.base.convert2Uppercase
import kotlin.properties.Delegates

/**
 * @author lvsdian
 * Created on 2020-08-03
 */

// 可观测属性的委托
// Delegates.observable接收两个参数，初始值、修改处理器。
//  处理器会在我们每次对属性赋值时得到调用（复制完成后被调用）
//  处理器本身接收3个参数，被赋值的属性本身，旧的属性值，新的属性值
// Delegates.vetoable的调用时机与Delegates.observable相反，它是在对属性赋值之前被调用，根据Delegates.vetoable的返回结果是true
//  还是false，来决定是否真正对属性进行赋值


class Person1 {
    // 通过observable函数可在赋值后做回调处理
    var age: Int by Delegates.observable(20) {
        property, oldValue, newValue ->
        println("${property.name}, oldValue: $oldValue, newValue: $newValue")
    }

    // 通过vetoable函数可在赋值后做回调处理,
    // 如果回调返回true,就可以修改属性值
    // 如果回调返回false，就不会修改属性值
    var score: Int by Delegates.vetoable(80) {
        property, oldValue, newValue -> when {
            newValue >= oldValue -> true
            else -> false
        }
    }
}


fun main(args: Array<String>) {
    val person1 = Person1()
    // age被Delegates.observable做了回调处理，所以这里修改age的值后，会执行observable函数
    person1.age = 30 //age, oldValue: 20, newValue: 30
    person1.age = 40 //age, oldValue: 30, newValue: 40

    println("--------------")

    // 这里score属性做了vetoable委托，在赋值前会执行vetoable函数，如果满足条件，才能成功修改score的值
    val person2 = Person1()
    println(person2.score)  //80

    person2.score = 70
    println(person2.score) // 80

    person2.score = 90
    println(person2.score) // 90


}
