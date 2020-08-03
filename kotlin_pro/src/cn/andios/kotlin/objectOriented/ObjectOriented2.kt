package cn.andios.kotlin.objectOriented

/**
 * @author lvsdian
 * Created on 2020-07-31
 */
open class Fruit {
    // 必须加上open修饰，才能被子类重写
    open fun name() {
        println("fruit")
    }

    fun expirationDate() {
        println("1 month")
    }
}

// Apple这个类继承了Fruit类
class Apple: Fruit() {
    // 被重写的这个方法必须加上override关键字，父类中这个方法必须加上open修饰，才能被重写
    override fun name() {
        println("apple")
    }
}

open class Orange: Fruit() {
    // 用final修饰这个方法后，Orange的子类不能再重写这个方法
    final override fun name() {
        println("orange")
    }
}

fun main(args: Array<String>) {
    var apple = Apple()
    apple.name()
    apple.expirationDate()
}