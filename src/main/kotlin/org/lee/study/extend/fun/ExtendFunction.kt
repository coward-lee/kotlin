package org.lee.study.extend.`fun`


fun String.println() {
    println(this);
}

fun <T> List<T>.println() {
    println(this);
}

/**
 * 成员变量
 */
var <T> MutableList<T>.firstElement: T
    get() {
        return this[0]
    }
    set(value) {
        this[0] = value
    }



fun main(args: Array<String>) {
    val mutableList = mutableListOf("ac", "bs", "cd")
    println(mutableList.firstElement)
}

