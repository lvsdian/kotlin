package cn.andios.kotlin.constructor

/**
 * @author lvsdian
 * Created on 2020-07-31
 */
class Person constructor(username: String) {
    private var username: String
    private var age: Int
    private var address: String

    init {
        this.username = "cnm"
        this.age = 20
        this.address = "beijing"
    }

    // secondary构造方法，一个secondary构造方法必须直接或间接的调用primary构造方法
    // 这个直接调用了包含username一个参数的primary构造方法，所以对于username参数的赋值依据primary构造方法
    constructor(username: String, age:Int): this(username) {
        this.age = 30
        this.address = "shanghai"
    }

    // 这里直接调用了上面一个secondary构造方法，间接调用了primary构造方法，所以对于username、age参数的赋值依据上面的secondary构造方法
    constructor(username: String, age: Int, address: String): this(username, age) {
        this.address = "xian"
    }

    fun printInfo(){
        println("username:$username, age:$age, address:$address")
    }
}
fun main(args: Array<String>) {
    var person1 = Person("zhangsan") //cnm 20 beijing
    var person2 = Person("lisi", 30) // cnm 30 shanghai
    var person3 = Person("wangwu", 40, "wuhan") //  cnm 30 xian

    person1.printInfo()
    person2.printInfo()
    person3.printInfo()
}