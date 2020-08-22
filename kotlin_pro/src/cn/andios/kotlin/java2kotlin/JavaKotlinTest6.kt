package cn.andios.kotlin.java2kotlin

/**
 * @author lvsdian
 * Created on 2020-08-22
 */

class Test6 {
    companion object {
        var name = "zhangsan"
        // 使用@JvmField修饰后伴生对象属性后，这个属性变成了public，这样就可以直接通过类的名字访问
        @JvmField
        var age = 20
    }
}
