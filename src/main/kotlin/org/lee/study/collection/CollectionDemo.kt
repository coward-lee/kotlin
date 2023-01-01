package org.lee.study.collection

import org.lee.study.extend.`fun`.println


fun main(args: Array<String>) {
    listOf("a", "b", "c", "d").forEach {
        println(it)
    }
    listOf("a", "b", "c", "d").forEachIndexed { index, value ->
        println("index=$index, value=$value")
    }
    listOf("a", "b", "c", "d").map {
//        return (it + "_" + it)  // 编译不通过
        (it + "_" + it)  // ??
    }.println()
//
//    val map:List<String> = listOf("a", "b", "c", "d").map {
//        return (it + "_" + it)  // 编译不通过
//    }

    listOf("a", "b", "c", "d").sorted().println()
    listOf("addd", "aab", "cs", "d").sortedBy {
        it.length
    }.println()
}