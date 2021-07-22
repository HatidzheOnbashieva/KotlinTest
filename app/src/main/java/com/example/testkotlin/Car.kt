@file:JvmName("StaticCar") //we can access all the top-level and extension functions function from a java class with this annotation name
package com.example.testkotlin

import java.io.IOException

fun topLevelFunction() = println("I'm in the Car file!")

fun main(){
    "Print this".print()
}

class CarJava (color: String, @JvmField val model:String, val year: Int, var isAutomatic: Boolean){ //we cannot use @JvmField annotation with private properties, property that overrides another property or a property that can be overridden
//    var color: String= color
//    set(value){
//        field = "always green"
//    }

    companion object{
        @JvmStatic fun carComp() = println("I am in Car's companion object") //by adding the annotation we are saying that we will use the static version of the method
    }
}

fun String.print(){
    println(this)
}

@Throws(IOException::class)
fun doIO(){
    throw IOException()
}

@JvmOverloads fun defaultArgs(str: String, num: Int = 25){ //the only function signature that Java sees is the full function signature; it generates only one version of the function which requires both parameters

}