package org.lee.study.annotation



@Target(AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
annotation class DefaultValue(val default: String)


@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.EXPRESSION
)
@Retention(AnnotationRetention.SOURCE)
@Repeatable
@MustBeDocumented
annotation class TestCase(val id: String)

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.EXPRESSION
)
@Retention(AnnotationRetention.SOURCE)
@Repeatable
@MustBeDocumented
annotation class Run


@Run
class Annotations {
    @TestCase(id = "1")
    @Run
    fun testCase(testId: String) {
        println("run sword test id = $testId")
    }
}

