package org.lee.study.oop


/**
 * 主构造函数至少包含一个参数
 * 参数必须标识为 val/var
 * 泵那位 abstract open sealed inner
 * 数据类不能继承其他类，但是可以实现接口
 */
data class LoginUser(val userName: String, val password: String)

/**
 * 二元组
 */


fun main(args: Array<String>) {
    val loginUser = LoginUser("admin", "admin")
    val (username, psw) = loginUser // 解构声明
    println("username=$username, password=$psw")

    /**
     * 二元组
     */
    val pair: Pair<String, String> = "a" to "b"
    println(pair)
    /**
     * 三元组
     */
    val triple = Triple("a","b","c")
    println(triple)
}
