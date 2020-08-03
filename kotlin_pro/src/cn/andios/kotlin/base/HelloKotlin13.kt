package cn.andios.kotlin.base

/**
 * @author lvsdian
 * Created on 2020-07-31
 */

// kotlin提供了4种可见性修饰符：
// private：只能在当前文件中使用
// protected
// internal：只能在同一个模块（编译后会编译到一起）中使用
// public：任何地方都能用

// 这种直接在包下面声明的方法称为顶层声明，如果不加修饰符，默认为public
// 如果一个顶层声明加上private修饰，那么只能在当前这个文件中可用
// 顶层声明（函数、类）不能用protected修饰

fun method() {

}

class Clazz{

}

// 如果private修饰类里面的成员，那么这个成员只能在当前类使用
// 如果protected修饰类里面的成员，那么这个成员能在当前类及子类中使用
// 如果internal修饰类里面的成员，那么这个成员在相同模块中能使用
// public:任何地方都能用