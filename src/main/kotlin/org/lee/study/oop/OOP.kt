package org.lee.study.oop


/**
 * 声明类
 */
class EmptyClass
class Person(var name: String, var age: Int) {
    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

/**
 * 先实例化，后期赋值
 */
class Person1 {
    var name: String? = null
    var age: Int? = null
    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

/**
 * 自定义构造参数，多个构造参数
 */
class Person2() { // 无参主构造器
    lateinit var name: String
    var age: Int = 0

    constructor(name: String) : this() { // 次构造器
        this.name = name
    }

    constructor(name: String, age: Int) : this() {// 次构造器
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

class Person3 { // 无参主构造器
    lateinit var name: String
    var age: Int = 0

    constructor()
    constructor(name: String) {
        println("single name")
        this.name = name
    }

    constructor(name: String, age: Int) : this(name) { // this(name) 调用对应的方法
        this.name = name
        this.age = age
    }


}

/**
 * 继承、多态
 */

abstract class Shape {
    abstract var width: Double
    abstract var height: Double
    abstract var radius: Double
    abstract fun area(): Double // 定义抽象函数

    fun onClick() { // 父类的函数默认是final，不可以被子类修改
        println("i am clicked!")
    }

    open fun onClick1() { // 允许子类重写函数，需要添加open关键字
        println("i am clicked1!")
    }
}   // 声明抽象父类 Shape

class Rectangle(
    override var width: Double,
    override var height: Double,
    override var radius: Double
) : Shape() {  // 继承类的语法使用 “ :  ” , 这类需要指定父类的构造函数进行初始化
    override fun area(): Double {
        return width * height
    }

//    override fun onClick(){ // 编译不通过
//        println("rectangle am clicked!")
//    }

    override fun onClick1() {
        println("rectangle am clicked!")
    }

}

class Circle(
    override var width: Double,
    override var height: Double,
    override var radius: Double
) : Shape() {  // 继承类的语法使用 “ :  ” , 这类需要指定父类的构造函数进行初始化
    override fun area(): Double {
        return Math.PI * radius * radius
    }

    override fun onClick1() {
        println("Circle am clicked!")
    }

}

/**
 * 接口
 */
class Project
interface ProjectService {
    val name: String
    val owner: String
    fun save(project: Project)
    fun print() {
        println("i am project service")
    }
}

class ProjectServiceImpl(
    override val name: String,
    override val owner: String
) : ProjectService {
    override fun save(project: Project) {
        print()
    }

    override fun print() {
        super.print() // 这个可以调用可以不调用7
    }
}

interface MilestoneService{

    fun print() {
        println("i am project MilestoneService")
    }
}
class ProjectMilestoneServiceImpl(
    override val name: String,
    override val owner: String
) : ProjectService,
    MilestoneService {
    override fun save(project: Project) {
        print()
    }

    override fun print() {
//        super<ProjectService>.print() // 调用对应的接口的 print 方法
//        super<MilestoneService>.print()
        // 也可以一个也不调用
    }
}


fun main() {
    /**
     * 实例化类
     */
    val emptyClass = EmptyClass()
    println(emptyClass)
    println(emptyClass is EmptyClass)
    println(emptyClass::class)

    /**
     *  带构造函数的, 构造参数赋值
     */
    val person = Person("jack", 111)
    println(person)

    /**
     *  默认构造参数，实例化后赋值
     */
    val person1 = Person1()
    person1.age = 111
    person1.name = "jack1"
    println(person1)
    /**
     * 多构造参数
     */
    var person2 = Person2()

    println("测试，构造参数调用")
    var person3 = Person3("xx", 111)
    println(person3)


    println("========================= 继承 =========================")

    val rectangle = Rectangle(3.0, 4.0, 0.0)
    println(rectangle is Shape)
    println(rectangle.area())
    rectangle.onClick()
    rectangle.onClick1()

    val circle = Circle(0.0, 0.0, 3.3)
    println(circle.area())
    rectangle.onClick()
    rectangle.onClick1()
    println(circle::class.simpleName)
}