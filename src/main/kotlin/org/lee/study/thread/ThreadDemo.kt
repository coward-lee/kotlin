package org.lee.study.thread


fun thread(
    start: Boolean = true,
    isDaemon: Boolean = false,
    classLoader: ClassLoader? = null,
    name: String? = null,
    priority: Int = -1,
    block: () -> Unit
): Thread {
    val thread = object : Thread() {
        override fun run() {
            block()
        }
    }

    if (isDaemon) {
        thread.isDaemon = true
    }
    if (priority > 0) {
        thread.priority = priority
    }
    if (name != null) {
        thread.name = name
    }
    if (classLoader != null) {
        thread.contextClassLoader = classLoader
    }
    if (start) {
        thread.start()
    }
    return thread
}

/**
 * 同步代码块
 */
@Synchronized
fun syncBlock() {
    Thread.sleep(2000)
    println("同步代码块： ${Thread.currentThread()}")
}

/**
 * volatile 关键字
 */
@Volatile private var running = false

fun main(args: Array<String>) {
    object : Thread() {
        override fun run() {
            Thread.sleep(3000)
            println("线程使用 对象表达式（object: Object(){} ） ： ${Thread.currentThread()}")
        }
    }.start()

    Thread({
        Thread.sleep(2000)
        println("线程使用 lambda表达式 ： ${Thread.currentThread()}")
    }).start()

    Thread {
        Thread.sleep(2000)
        println("线程使用 lambda表达式简介化： ${Thread.currentThread()}")
    }.start()
    thread(start = true) {
        println("工厂方法创建线程")
    }
    Thread.sleep(3000)

    Thread {
        syncBlock()
    }.start()
    Thread {
        syncBlock()
    }.start()
    Thread {
        syncBlock()
    }.start()
    Thread {
        syncBlock()
    }.start()
    Thread {
        syncBlock()
    }.start()
}