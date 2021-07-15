package com.example.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

val topLevelName = "Hatidzhe"; //top-level variables; moved to the .kt file; can be used as local variables
var topLevelNullname:String? = null; //making a variable nullable; means that a variable can be assigned a null value

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fullName: String =
            "Hatidzhe Onbashieva" //mutable variables which can have their values reassigned
        val nickname: String =
            "Hati" //local read-only variables which can be assigned only once; if i try to update name - not possible



        val newTopLevelName1: Int? = topLevelNullname?.length;
        topLevelNullname = "Null name var"
        val newTopLevelName2: Int = topLevelNullname!!.length;
        println(newTopLevelName1)
        println(newTopLevelName2)

        val nullableList: List<Int?> = listOf(1, 2, null, 4)
        val intList: List<Int> = nullableList.filterNotNull()
        println(intList)

        var a = 1
// simple name in template:
        val s1 = "a is $a"

        a = 2
// arbitrary expression in template:
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        println(s2)

        val listOfItems = listOf("banana", "kiwi", "apple")
        for(index in listOfItems.indices)
            println("fruit at index $index is ${listOfItems[index]}")

        var index = 0
        while(index < listOfItems.size)
        {
            println("fruit at index $index is ${listOfItems[index]}")
            index++
        }

        val x:Any = "Hello";
        var variable: String? = when (x){
             1 -> "x is one"
            2 -> "x is two"
            3 -> "x is three"
            else -> "unknown value"
        }

        println(variable)

        val y = 4
        if (y in 10.downTo(1) step 2) println(y) else println("not in range") // it is going to search for 4 starting from 10 and going down to 0 with step 2 - 10, 8, 6, 4,2,0

        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits
            .filter { it.startsWith('k') }
            .sortedBy { it }
            .map { it.uppercase() }
            .forEach{(println(it))}
        //println(fullName)
        //println(nickname)

        //println(topLevelName)

        /* when(fullName)
        {
            !is String -> {
                fullName = "Hati"
             println(fullName)
            }

            else -> println("When loop")

        }

        println(getGreeting())
        hello()

    }

    fun getGreeting(): String{

        return "Hello Kotlin"
    }

    fun hello()
    {
        println(getGreeting())
    }*/

        val person = Person("Ivan", "Petrov")
        //person.firstname is known as property access syntax; in Kotlin we can directly reference properties by their name without worrying about a getter or setter
        println("\nFirst name: ${person.firstname} \nLast name: ${person.lastName}")

        val map = mapOf("a" to 1, "b" to 2, "c" to 3)
        println(map["a"])
        println(map.getValue("a"))
        //map.forEach { key, value -> println("$key = $value")}
        for((key, value) in map)
            println("$key = $value")

        infix fun String.onto(other: String) = Pair(this, other)
        val myPair = "McLaren" onto "Lucas"
        println(myPair)
    }
}