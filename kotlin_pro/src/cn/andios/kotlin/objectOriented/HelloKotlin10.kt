package cn.andios.kotlin.objectOriented

/**
 * @author lvsdian
 * Created on 2020-07-31
 */


/*
    var propertyName: propertyType = initializer
        getter()...
        setter()...
 */
class ThePerson(address: String, name: String) {

    val age: Int
        get() = 20

    var address: String = address
        get() {
            println("get invoked")
            // field表示真正存放值的那个数据，只能用在get、set中，是支撑字段（backing field），
            // 类似的还有支撑属性（backing property）
            return field
        }
        set(value) {
            println("set invoked")
            field = value
        }
}

fun main(args: Array<String>) {
    var person = ThePerson("beijing", "zhangsan")

    // 直接访问age
    println(person.age)

    // 调用get方法，再打印这个值
    println(person.address)

    // 调用set方法，赋值field
    person.address = "tianjin"

    // 调用get方法，再打印这个值
    println(person.address)

}