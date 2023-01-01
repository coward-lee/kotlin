package org.lee.study.oop




enum class Color(val code: Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

fun main(args: Array<String>) {
    println(Color.RED.code)
    println(Color.GREEN.code)
    println(Color.BLUE.code)
}