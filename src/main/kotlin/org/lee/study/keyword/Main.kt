package org.lee.study.keyword

import java.lang.Integer.parseInt

// crossinline 不允许lambda 中含有return关键字
inline fun f(crossinline body: () -> Unit){
    val f = object: Runnable{
        override fun run()  = body()
    }
}


fun casesWhen(obj: Any?){
    when(obj){
        0,1,2,3,4,5,6,7,8,9 -> println("${obj}  ===>  this is a num in 0-9")
        "hello" -> println("${obj} is a hello world")
        is Char -> println("${obj} is a Char")
        else -> println("${obj} is what ? ")
    }
}
fun switch(x:Int){
    val s = "123"
    when(x){
        -1,0 -> println("x == -1 or x == 0")
        1 -> println("x == 1")
        2 -> println("x == 2")
        8 -> println("x == 8")
        parseInt(s) -> println(" x is  123")
        else -> { // ?
            print("none of the above")
        }
    }
}

/**
 *  when  范围匹配
 */
fun inTest(x:Int){
    when(x){
        in 1..10 -> print("x in the range")
        in listOf(2,3,4,33,555,999) -> println("x is valid")
        !in 10..20 -> println("x is invalid")
        else -> println("default output")
    }
}

/**
 * for 循环
 */
fun forTest(){
    val col = listOf("a","b","b")
    for(item in col){
        println(item)
    }
    for(i in col.indices){
        println("index : $i ")
    }
    // 下标加值
    for((index, value) in col.withIndex()){
        println("index:$index -----> value:$value ")
    }
}

fun main() {
    casesWhen(1)
    casesWhen("hello")
    casesWhen('a')
    casesWhen(null)
    inTest(1)
    inTest(222)
    inTest(12)
    inTest(33)
    inTest(999)
    println("======================for 循环=====================")
    forTest()
}