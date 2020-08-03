package cn.andios.kotlin.objectOriented

/**
 * @author lvsdian
 * Created on 2020-07-31
 */
open class BaseClass {
    open fun method() {

    }
}

// 如果父类是一个普通的类，子类是个抽象类
// 那么子类这个抽象类中的方法可以用一个抽象方法来重写父类的具体方法
abstract class ChildClass: BaseClass() {
    override abstract fun method()
}