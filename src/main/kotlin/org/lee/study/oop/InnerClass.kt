package org.lee.study.oop


class NestedClassesDemo {
    class Outer {
        private val zero: Int = 0
        val one: Int = 1

        class Nested {
            fun getTwo() = 2
            class Nested1 { // 内嵌类，  public static final class Nested
                val three = 3
                val four = 4
            }

            fun accessOuter() {
//                println(zero)// 无法访问
//                println(one)// 无法访问
            }
        }

        inner class Inner { //  public final class Inner {}
            fun accessOuter() {
                println(zero) // 可以访问
                println(one)  // 可以访问
            }
        }
    }

    class AnonymousInnerClassDemo {
        fun doRun() { // 匿名内部类
            Thread(
                object : Runnable {
                    override fun run() {
                        println("run run run")
                    }
                }
            ).start()
            Thread(Runnable { // 函数式接口化
                println("run run run")

            }).start()
            Thread { // 函数式接口化
                println("run run run")

            }.start()
        }
    }
}

fun main(args: Array<String>) {
    println(NestedClassesDemo.Outer().one)
    println(NestedClassesDemo.Outer.Nested().getTwo())
    println(NestedClassesDemo.Outer.Nested.Nested1().three)
    println(NestedClassesDemo.Outer.Nested.Nested1().four)
}