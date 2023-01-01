package org.lee.study.oop


/**
 * object 关键字，即使一个静态单例类
 */
object User {
    val username: String = "admin"
    val password: String = "admin"
    fun hello(){
       println("  Hello, object!")
    }
}
//class User{ // 伴生对象不像 scala那样
//
//}

/**
 * 伴生对象如下
 */
class DataProcessor{
    companion object DataProcessor{
        fun process(){
            println("process")
        }
    }
}

fun main(args: Array<String>) {
    println(User.username) // 调用静态成员变量
    println(User.password)
    User.hello()// 调用静态方法
    DataProcessor.process()
}