package cn.andios.kotlin.delegation

import java.lang.Exception
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * @author lvsdian
 * Created on 2020-08-03
 */

// 委托转换规则
//      对于每个委托属性来说，kotlin编译器在底层会生成一个辅助的属性，然后将对原有属性的访问委托给这个辅助属性
//      比如说，对于属性prop来说，kotlin编译器会生成所隐含的属性名为prop$delegate，然后对原有的prop属性的访问器的访问都只是委托给了这
//      个额外的，kotlin编译器所生成的辅助属性
// 提供委托(providing a delegate)
//      通过定义provideDelegate operator，我们可以扩展委托的创建逻辑过程，如果对象定义了provideDelegate方法，那么该方法就会被调用来创建属性委托实例

class PropertyDelegate: ReadOnlyProperty<People, String> {
    override fun getValue(thisRef: People, property: KProperty<*>): String {
        return "hello"
    }
}

class PeopleLauncher {
    operator fun provideDelegate(thisRef: People, property: KProperty<*>): ReadOnlyProperty<People, String> {
        println("welcome")

        when (property.name) {
            "name", "address" -> return PropertyDelegate()
            else -> throw Exception("not valid name")
        }
    }
}

class People {
    val name: String by PeopleLauncher()
    val address: String by PeopleLauncher()
}

fun main(args: Array<String>) {
    val people = People()
    println(people.name)
    println(people.address)
}
