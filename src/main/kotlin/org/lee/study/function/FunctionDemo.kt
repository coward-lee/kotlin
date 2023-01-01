package org.lee.study.function

/**
 * 函数作为参数
 */
fun funDemo1(f: (a: Int, b: Int) -> Int): Int {
    val a = 1
    val b = 2
    return f(a, b)
}

/**
 * 函数作为参数, 同时使用 typealias 作为别名
 */
typealias intToInt = (Int, Int) -> Int

fun funDemo2(f: intToInt): Int {
    val a = 1
    val b = 2
    return f(a, b)
}

fun myFun(): String {
    println("myFun executed")
    return "run"
}

fun testRunFun() {
    myFun()
    run({ myFun() }) // 传入函数
    run { myFun() }  // 写法简化
    run { println("xxxx") } // 直接执行代码
}

/**
 * apply 函数
 */
fun testApply() {
    val list = mutableListOf<String>()
    list.add("xxx1")
    list.add("xxx2")
    list.add("xxx3")

    println("普通写法")
    println(list)

    ArrayList<String>().apply { // 调用apply方法
        add("xxx1")
        add("xxx2")
        add("xxx3")
        println("apply 方法 this=$this")
    }
}

/**
 * let 函数
 */
fun testLetFun() {
    println("============================ let 函数 =====================")
    1.let { println(it) } //it 就是1 本身
    "ABC".let { i ->  // 这个i就是ABC本身
        println(i)
    }
    myFun().let { println(it) } // 就是函数本省
}

/**
 * also 函数
 */
fun testAlsoFun() {
    println("============================ also 函数 =====================")
    val abc = "ABC".also { i ->  // 这个i就是ABC本身
        println(i)
    }
    println(abc)
    myFun().also { println(it) } // 就是函数本省
}
/**
 * with 函数, 与apply类似但是更简洁, 但是需要自己指定返回内容
 */
fun testWithFun(){

    println("============================ with 函数 =====================")
    val list = mutableListOf<String>()
    list.add("xxx1")
    list.add("xxx2")
    list.add("xxx3")

    println("普通写法")
    println(list)

    with(ArrayList<String>()){
        add("xxx1")
        add("xxx2")
        add("xxx3")
        println("with 方法 this=$this")
    }.let { println("let $it") }

    with(ArrayList<String>()){
        add("xxx1")
        add("xxx2")
        add("xxx3")
        this
    }.let { println("let $it") }
}


/**
 * 高阶函数
 */
fun main(args: Array<String>) {
    testRunFun()
    testApply()
    testLetFun()
    testAlsoFun()
    testWithFun()
}