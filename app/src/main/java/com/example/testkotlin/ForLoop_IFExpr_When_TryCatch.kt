package com.example.testkotlin

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.math.BigDecimal

fun main() {

    //  For loop examples


    val intRange = 1..5
    val charRange = 'a'..'z'
    val stringRange = "ABC".."XYZ"

    println(3 in intRange) //true
    println('q' in charRange) //true
    println("CCC" in stringRange) //true
    println("CCCCC" in stringRange) //true
    println("ZZZZZZ" in stringRange) //false

    val backwardRange = 5.downTo(1) // backward from 5 to 1; reverse order
    println(5 in backwardRange) //true

    val stepRange = 3..15
    val stepThree = stepRange.step(3)
    val reversedRange = intRange.reversed()

    for(num in 1..20 step 4)
        println(num)

    for(num in 20 downTo 15 )
        println(num)

    for(num in 20.downTo(15))
        println(num)


    for(num in 20 downTo 10 step 5)
        println(num)

    for (num in 1 until 10)
        println(num) //number 10 will be excluded; 1..9 will be printed

    val seasons = arrayOf("spring", "summer", "fall", "winter")

    for(season in seasons)
        println(season)

    seasons.forEach { println(it) }//same as the above but more concise
    seasons.forEachIndexed {index, value -> println("$value is season number $index")} //same as the below one but more concise

    for(index in seasons.indices)
        println("${seasons[index]} is season number $index")

    val notSeason = "whatever" !in seasons
    println(notSeason) //true

    val notInrange = 32 !in 1..10 //32 not in range from 1 to 10
    println(notInrange) //true

    for (i in 1..3) {
        println("i= $i")
        jloop@ for (j in 1..4) {
            println("j = $j")
            for (k in 5..10) {
                println("k = $k")
                if( k == 7)
                    break@jloop;
            }
        }
    }







    //If expression examples

    val condition = 1 > 3
    val num = if(condition) 50 else 60 //the if can evaluate to a value
    println(num)


    val num2 = if(condition){
        println("something")
        50 //you need to put the return value as the last statement in each block; if you try: val num2:String -> will give an error
    }else{
        println("something else")
        60
    }
    println(num2)


    //same as above
    println(if(condition){
        println("something")
        50 //you need to put the return value as the last statement in each block; if you try: val num2:String -> will give an error
    }else{
        println("something else")
        60
    })

    println("The result of the if expression is ${if(condition){
        println("something")
        50 //you need to put the return value as the last statement in each block; if you try: val num2:String -> will give an error
    }else{
        println("something else")
        60
    }}")


    //When expression

    val number = 400
    val y = 100

    when(number){
        in 100..199 -> println("in range 100..199")
        200 -> println("200")
        y + 300 -> println("400")
        else -> println("Doesn't match anything")
    }


    val something: Any = "I am a string"
    val something2: Any = BigDecimal(25.2)

    when(something){
        is String -> println(something.toUpperCase())
        is BigDecimal -> println(something.remainder(BigDecimal(10.5))) //it is dividing something2 - 25.2 by 10.5 and getting the remainder
        is Int -> println("${something - 22}")
        else -> println("I have no idea what type something is")
    }

    val z = when(something){
        is String -> {
            println(something.toUpperCase())
            1
        }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(10.5)))  //it is dividing something2 - 25.2 by 10.5 and getting the remainder
            2
        }
        is Int -> {
            println("${something - 22}")
            3
        }
        else -> {
            println("I have no idea what type something is")
            -1

        }
    }
    println(z)

    var i = 100
    val timeOfYear = Season.SPRING
    val str = when (timeOfYear){
        Season.SPRING -> {
            i += 5
            "Flowers are blooming"
        }
        Season.SUMMER -> "It is hot"
        Season.FALL -> "I is getting cooler"
        Season.WINTER -> "I need a coat"
    }

    println(str) //when we use enum's all members we don't need to declare else because we have covered all the conditions for that enum class

    val i2 = -50

    //when you have a bunch of con if..else conditions it is better to use when
    when{
        num < num2 -> println("Num is less than num2")
        num > num2 -> println("Num is greater than num2")
        else -> println("Num equals num2")
    }


    //Try Catch Expression

    //println(getNumber("11.5") ?: throw IllegalArgumentException("Number isn't an Int")) //once the exception is thrown the execution stops in the main function
    println(getNumber("11.5") ?: "I can't print the result")


    //notImplementedYet("string")

}

enum class Season
{
    SPRING, SUMMER, FALL, WINTER
}

fun getNumber(str: String): Int?{
    return try{ //we can also use try catch and assign it to a variable
        Integer.parseInt(str)
    }catch(e: NumberFormatException){
        null
    }finally{
        println("I'm in the finally block") //we cannot return a value from a finally block
    }
}

fun notImplementedYet(something: String): Nothing{ // a function that will never return sth and always will throw exception
    throw IllegalArgumentException("Implement me")
}