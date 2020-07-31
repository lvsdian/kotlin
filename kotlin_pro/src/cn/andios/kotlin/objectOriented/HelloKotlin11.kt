package cn.andios.kotlin.objectOriented

/**
 * @author lvsdian
 * Created on 2020-07-31
 */

// kotlin要求非空类型的属性必须在构造方法中进行初始化
// 有时这种要求不太方便，比如可以通过依赖注入或者单元测试情况下进行属性的赋值
// 通过 lateinit关键字标识属性为延迟初始化，需要满足如下3个条件
// 1. lateinit只能用在类体中声明的var属性上，不能用在primary constructor声明的属性上
// 2. 属性不能拥有自定义的setter和getter
// 3. 属性类型需要为非空，且不能是原生数据类型
class TheClass {
    // 声明了延迟初始化后，kotlin
    lateinit var name: String

    fun init() {
        this.name = "zhangsan"
    }

    fun print() {
        println(this.name)
    }
}