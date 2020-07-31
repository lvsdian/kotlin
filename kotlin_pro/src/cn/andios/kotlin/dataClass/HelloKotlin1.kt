package cn.andios.kotlin.dataClass

/**
 * @author lvsdian
 * Created on 2020-07-31
 */

// 数据类-data class，即pojo
// 数据类需要满足如下要求
// 1. 主构造方法至少要有一个参数
// 2. 所有的主构造方法参数都需要被标记为var或者val
// 3. 数据类不能是abstract、open、sealed、inner
// 对于数据类，编译器会自动生成如下内容：
// 1. equals/hashCode
// 2. toString()方法，形式为Person(name=..., age=..., address=...)
// 3. 针对属性的componentN方法，并且是按照属性的声明顺序来生成的

// 数据类成员的继承要点
// 1. 如果数据类中显示定义了equals，hashCode或是toString方法，或是在数据类的父类中将这些方法声明为final，
//      那么这些方法不会再生成，转而使用已有的
// 2. 如果父类拥有componentN方法，并且是open的以及返回兼容的类型，那么编译器就会在数据类中生成相应的componentN方法，
//      并且重写父类的这些方法，如果父类中的这些方法由于不兼容的签名或是被定义为final的，那么编译器就会报错
// 3. 在数据类中显式提供componentN方法以及copy方法实现是不允许的
//
// componentN方法作用是解构声明
// 在主构造方法中有多少个参数，就会依次生成对应的component1, component2, component3
// 这些方法返回的就是对应字段的值，componentN方法就是用来实现解构声明的


data class Person1(val name: String, var age: Int, var address: String)

fun main(args: Array<String>) {
    var person1 = Person1("zhangsan", 20, "beijing")
    println(person1)

    person1.age = 2

    var person2 = person1.copy(address = "hangzhou");
    println(person2)

    // 解构：将一个对象的属性顺序将对象分成多个变量
    var (name, age, address) = person1
    println("$name, $age, $address")    // zhangsan, 2, beijing
    println("$name, $address")          // zhangsan, beijing

}

// 在jvm平台上，如果生成的类需要拥有无参构造方法，那么就需要为所有属性指定默认值
data class Person2(val name: String = " ", var age: Int, var address: String = "shanghai")