package com.example.testkotlin

fun main(){
    val immutableMap = mapOf(1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        5 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013),
        4 to Car("blue", "Ford", 2014))

    println(immutableMap.javaClass)
    println(immutableMap)

    val mutableMap = hashMapOf<String, Car>("John's car" to Car("red", "Range Rover", 2010), "Jane's car" to Car("blue", "Hyundai", 2012))
    println(mutableMap.javaClass)
    println(mutableMap)
    mutableMap.put("Mary's car", Car("red", "Corvette", 1965)) //if you are going to use a hash map it is always going to be mutable

    for((key, value) in mutableMap)
    {
        println(key)
        println(value)
    }

    val pair = Pair(10,"ten")
    val (firstValue, secondValue) = pair
    println(firstValue)
    println(secondValue)

    val car = Car("blue", "Toyota", 2012) // if we have declared Car class as data class we can directly use destructuring declaration like this
    val(color, model, year) = car
    println("Color: $color, Model: $model, Year: $year")

    val car2 = Car2("blue", "Toyota", 2012) // to use destructuring declaration if we haven't declare class Car as data class; adding component
    val(color2, model2, year2) = car2
    println("Color: $color2, Model: $model2, Year: $year2")

    val setInts = setOf(10,15,19,5,3,-22)
    println(setInts.plus(20)) //the set is not changed because the set is immutable
    println(setInts.plus(10)) //sets cannot contain duplicate elements
    println(setInts.minus(19)) //we don't have 19 in the set; we are not really adding or removing values from the set; we are just printing them out
    println(setInts.minus(100)) //nothing will happen
    println(setInts.average())
    println(setInts.drop(3)) // dropping the first three elements from the set; works with all type of collections

    val mutableInts = mutableSetOf(1,2,3,4,5)
    mutableInts.plus(10) //doesn't change the original collection; (plus/minus) doesn't work directly on the set; used only for printing
    println(mutableInts)

    println(setInts.filter { it % 2 != 0 })

    val mutableMap2 = mutableMapOf(1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013),
        4 to Car("blue", "Ford", 2014))

    mutableMap2.filter { it.value.color == "silver" }
    println("the filtered map is $mutableMap2")

    val ints = arrayOf(1,2,3,4,5)
//    val add10List: MutableList<Int> = mutableListOf()
//    for (i in ints){
//        add10List.add(i + 10)
//    }
//    println(add10List)

    val add10List = ints.map { it + 10} //same as above but way more concise
    println(add10List)

    println(immutableMap.toSortedMap()) //sorted by key
    println(immutableMap.all { it.value.year > 2014}) //false
    println(immutableMap.any { it.value.year > 2014}) //true
    println(immutableMap.count { it.value.year > 2014})

    println(immutableMap.filter { it.value.model == "Ford"}.map { it.value.color})
    val cars = immutableMap.values
    println(cars.find { it.year > 2014})//the find function finds the first item in the list that satisfies the condition and then stops
    println(cars.groupBy { it.color }) //it is like a map creating key -> value
    println(cars.sortedBy { it.year })

}