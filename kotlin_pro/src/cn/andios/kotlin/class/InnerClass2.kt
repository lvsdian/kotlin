package cn.andios.kotlin.`class`

/**
 * @author lvsdian
 * Created on 2020-08-02
 */

class Person(val name: String, var age: Int) {
    
    private val str: String = "person属性"
    
    private inner class PersonFeature(var height: Int, var weight: Int) {
        
        private val str: String = "PersonFeature属性"
        
        fun getPersonFeature(){
            
            val str: String = "局部变量"

            // 访问外部类变量
            println(this@Person.str)
            // 访问本类变量
            println(this.str)
            // 访问局部变量 
            println(str)
            
            println("身高： $height，体重：$weight")
            this@Person.method()
        }
    }

    private fun method() {
        println("执行Person的method方法")
    }

    fun getPerson() {
        val personFeature = PersonFeature(120, 180)
        personFeature.getPersonFeature()

    }
}

fun main(args: Array<String>) {
    val person = Person("zhangsan", 20)
    person.getPerson()

}
