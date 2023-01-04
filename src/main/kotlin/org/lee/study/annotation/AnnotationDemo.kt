package org.lee.study.annotation



@Run
class SwordTest {
    @TestCase(id = "1")
    fun testCase(testId: String) {
        println("run sword test id = $testId")
    }
}



fun demo() {
    val swordTest = SwordTest()
    val kClass = swordTest::class

    println("=======================================")
    kClass.members.forEach { d ->
        println(d)
        d.annotations.forEach {
            if (it is TestCase) {
                println(it.id)
            }

        }
    }
}

fun main(args: Array<String>) {
    demo()
}
