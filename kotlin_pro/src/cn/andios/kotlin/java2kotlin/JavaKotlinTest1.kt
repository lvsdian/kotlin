package cn.andios.kotlin.java2kotlin

// 属性（properties)
// 一个kotlin属性会被编译为3部分java元素
// 1.一个getter方法
// 2.一个setter方法
// 3.一个私有的字段，其名字与kotlin的属性名一样
// 如果kotlin属性名以is开头，那么命名约定会发生一些变化
// 1.getter方法名与属性名一样
// 2.setter方法名字则是将is替换为set
// 3.这种规则适用于任何类型，而不单单是boolean类型


class MyTest{
    val name: String = "loser"
}
