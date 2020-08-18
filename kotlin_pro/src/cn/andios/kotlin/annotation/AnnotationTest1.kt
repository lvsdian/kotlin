package cn.andios.kotlin.annotation

// 注解 annotation
// meta-annotation(元注解)

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD,
        AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class MyAnnotation1

@MyAnnotation1
class MyClass1 {

    @MyAnnotation1
    fun myMethod(a: Int): Int {
        return 10
    }
}

// 用在构造器上
class MyClass2 @MyAnnotation1 constructor(a: Int) {

}

