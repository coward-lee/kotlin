package org.lee.study.singleton


object SingletonDemoEager // 餓漢式的kt版本


class SingletonDemoLazy{
    companion object{
        private var instance : SingletonDemoLazy? = null
            get() {
                if (field == null){
                    field = SingletonDemoLazy()
                }
                return field
            }
        fun getInstanceAction():SingletonDemoLazy? = instance!!
    }

    fun show(){
        println("show")
    }
}

fun main(args: Array<String>) {

    println(SingletonDemoLazy.getInstanceAction())
}