package org.lee.study.generic.type


open class Shape

class Rectangle : Shape()

class Triangle : Shape()

fun genericParadigm(
    src: MutableList<out Shape>,
//                    dest:List<in Shape> // Projection is conflicting with variance of the corresponding type parameter of List. Remove the projection or replace it with '*'
    dest: MutableList<in Shape>
) {
    val shape1: Shape = src[0]
    dest[0] = shape1
}

fun main(args: Array<String>) {
    val li: MutableList<out Shape> = mutableListOf(Shape())
//    genericParadigm(listOf(), listOf<Shape>())
}