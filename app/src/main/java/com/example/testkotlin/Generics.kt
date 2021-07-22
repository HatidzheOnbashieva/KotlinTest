package com.example.testkotlin

import java.lang.Appendable
import java.lang.StringBuilder
import java.math.BigDecimal

fun main(){
   val list = mutableListOf("Hello")
   list.add("another string")
   printCollection(list)
   list[0].toUpperCase()

   val bdlist = mutableListOf(BigDecimal(-33.45), BigDecimal(3503.99), BigDecimal(0.329))
   printCollection(bdlist)

   bdlist.printCollection2()

   val ints = listOf(1,2,3,4,5)
   val shorts: List<Short  > = listOf(10,20,30,40)
   val float: List<Float?> = listOf(100.3f, -459.43f)
   val strings = listOf("1", "2","3")

   convertToInt(shorts)
   convertToInt(float)

   printCollection(shorts)
   printCollection(strings)

   append(StringBuilder("String 1"), StringBuilder("String 2"))

   var mixedList: List<Any> = listOf("string", 1, BigDecimal(22.5), "fall", BigDecimal(-5938.393849))
   val bigDecimalsOnly = getElementsOfType<String>(mixedList)
   for(item in bigDecimalsOnly)
      println(item)

   val shortList: List<Short> = listOf(1,2,3,4,5)
   convertToAnInt(shortList)

}
fun convertToAnInt(collection: List<Number>){
   for (num in collection){
      println("${num.toInt()}")
   }
}
fun <T: Any> printCollection(collection: List<T>){ //we will take any non-nullable type
   for (item in collection)
      println(item)
}

fun <T> List<T>.printCollection2(){
   for(item in this){
      println(item)
   }
}

fun <T: Number?> convertToInt(collection: List<T>){ // we are only accepting numbers for this function
   for(num in collection){
      println("${num?.toInt()}")
   }
}

fun <T> append(item1: T, item2: T) where T: CharSequence, T:Appendable{
   println("Result is ${item1.append(item2)}")
}

inline fun <reified T> getElementsOfType(list: List<Any>) : List<T>{ //if you declare a function inline and type parameter as reified then we can check the generic type at runtime;
// the type isn't erased at runtime; so we need to do this when we want to check the type within a function otherwise there is no need
   //we cannot mark classes, properties or non-inline functions as reified

   var newList: MutableList<T> = mutableListOf()
   for(element in list){
      if(element is T){
         newList.add(element)
      }
   }
   return newList
}

/*
fun tendGarden(roseGarden: Garden<Rose>){ //it won't accept a garden of Roses but only a Flower; subclasses of FLower are not being accepted
   waterGarden(roseGarden)
}
fun waterGarden(garden: Garden<Flower>){

}
open class Flower{

}

class Rose : Flower(){

}

class Garden<T: Flower>{ //this class is invariant; wants

}*/

fun tendGarden(roseGarden: Garden<Rose>){ //garden can accept the subclasses of Flower
   waterGarden(roseGarden)
}
fun waterGarden(garden: Garden<Flower>){

}
open class Flower{

}

class Rose : Flower(){

}

class Garden<out T: Flower>{ //by adding the out keyword we are making Garden covariant; you can only use a covariant class in out positions

   val flowers: List<T> = listOf()
   fun pickFlower(i: Int): T = flowers[i]
//   fun plantFlower(flower: T){ //we have declared Garden put so we can use out only as out parameter
//
//   }
}
