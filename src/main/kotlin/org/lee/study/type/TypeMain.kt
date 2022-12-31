package org.lee.study.type


fun main() {
    val a : Int? = 10000
    val b : Int? = 10000
    println(a == b)
    println(a === b)


    var arr = arrayOf("1", "2")
    val array = Array(5, { i -> i * i })
    array.forEach (::print)
    println()
    booleanArrayOf() // BooleanArray
    charArrayOf() // CharArray
    byteArrayOf() // ByteArray
    shortArrayOf() // ShortArray
    intArrayOf() // IntArray
    longArrayOf() // LongArray
    floatArrayOf() // FloatArray
    doubleArrayOf() // DoubleArray

    // 可空类型

    println("================ 可空类型 ======================")
    println(canEmpty(null)?:"xxxxxx")

    println(null is Any)
    println(null is Any?)
    /**
     * ? 安全强调符 表示该类型可以为空
     * !! 非空断言
     * :? elvis 运算符
     */
    val nullTest:String? = null
    println(nullTest)
    // println(nullTest!!.length) //NullPointerException
    println(nullTest?:"xxxxx")

    /**
     * Unit 类型
     */
    println(Unit.toString())
    /**
     * Nothing类型与java的Void类型相同
     */
//    println(Nothing?)

    /**
     * as test
     */
    println("================ as test ======================")
    println(asTest(listOf("x","ss")))
}

/**
 * 下面三个方法等价
 */
fun unitReturn1(){

}
fun unitReturn2(){
    return Unit
}
fun unitReturn3():Unit{
}

fun nothingTest1():Nothing{
    throw IllegalAccessError("xxxxxxxxxxxxx")
}
fun nothingTest2():Nothing?{
    throw IllegalAccessError("xxxxxxxxxxxxx")
}

fun canEmpty(name: String?):String?{
    return name;
}

fun isTest(t:Any?){
    if (t is String){
        println(t.length)
    }
    if (t is List<*>){
        println(t.size)
    }
}

fun asTest(t:List<*>){
    println(t as Collection<*>)
}