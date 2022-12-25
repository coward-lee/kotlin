package org.lee.study.hello

import org.lee.study.extend.`fun`.println

fun main(args:Array<String>) {
    "hello world".println()

    var a = "abc"
    // 无法赋值null
    // a = null

    var b:String? = "abc"
    // 可以赋值为空
    b = null
    // 需要环绕空检查
//    b.length
    println(b?.length) // 输出 null


}