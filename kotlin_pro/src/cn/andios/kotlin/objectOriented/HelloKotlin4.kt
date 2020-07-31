package cn.andios.kotlin.objectOriented

/**
 * @author lvsdian
 * Created on 2020-07-31
 */

// 在kotlin中，所有类在默认情况下都是无法被继承的
// 换句话说，在kotlin中，所有类默认情况下都是final的
// open的含义与final相反

open class Parent (name: String, age: Int) {

}

// Child类继承Parent类，Parent只有用open修饰才能被继承，否则Parent默认是final的就无法被继承
// 同理，Child没有用open修饰，所以它也无法被继承
class Child (name: String, age: Int): Parent(name, age){

}


open class Parent2(name: String) {

}
// 在Kotlin中，如果一个类没有primary构造方法，那么这个类的每个secondary构造方法就需要super关键字来初始化赋类型，
// 或是通过其他secondary构造方法完成这个任务
// 不同的secondary构造方法可以调用父类型不同的构造方法
class Child2: Parent2{
    constructor(name: String):super(name) {

    }
}