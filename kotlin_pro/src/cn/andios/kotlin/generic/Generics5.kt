package cn.andios.kotlin.generic

/**
 * @author lvsdian
 * Created on 2020-08-02
 */

// star projection（星投影）

// 如果Star的泛型类型为：Star<out T>，假设T的上界是TUpper，
//  那么Star<*>就相当于Star<out T>,这表示当T的类型未知时，你就可以从Star<*>当中安全的读取TUpper类型的值

// 如果Star的泛型类型为：Star<in T>，
// 那么Star<*>就相当于Star<in Nothing> ，这表示你无法向其中写入任何值

// 如果Star的泛型类型为：Star<T>，假设T的上界为TUpper，
// 那么Star<*>就相当于读取时的Star<out TUpper>以及写入时的Star<in Nothing>

// case 1
class Star1<out T> {
}

// case 2
class Star2<in T> {
    fun setValue(t: T) {}
}

// case 3
class Star3<T> (private var t: T) {
    fun setValue(t: T) {}
    fun getValue(): T {
        return this.t
    }
}

fun main(args: Array<String>) {
    // case 1
    // star2可以从Star<*>当中安全的读取TUpper类型的值,
    val star1: Star1<Number> =
        Star1<Int>()
    val star2: Star1<*> = star1

    // case 2
    // star4的泛型Star<*>相当于Star<in Nothing>，不能写入任何类型，所以会编译错误
    val star3: Star2<Int> =
        Star2<Number>()
    val star4: Star2<*> = star3
    // star4.setValue(3) // compile error

    // case 3
    // star6的泛型Star<*>可读，不可写
    var star5: Star3<String> =
        Star3<String>("hello")
    val star6: Star3<*> = star5
    // star6.getValue() // √
    // star6.setValue("") //compile error

    val list: MutableList<*> = mutableListOf("hello", "world")
    // list[0] = "test" //compile error
}
