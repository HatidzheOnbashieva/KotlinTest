package com.example.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

val topLevelName =
    "Hatidzhe"; //top-level variables; moved to the .kt file; can be used as local variables
var topLevelNullname: String? =
    null; //making a variable nullable; means that a variable can be assigned a null value

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fullName: String =
            "Hatidzhe Onbashieva" //mutable variables which can have their values reassigned
        val nickname: String =
            "Hati" //local read-only variables which can be assigned only once; if i try to update name - not possible

        println("The full name value: $fullName")
        println("The nickname value: $nickname")

        println("Top-level name is $topLevelName")

        when (fullName) {
            "Hatidzhe Onbashieva" -> {
                fullName = "Hati"
                println(fullName)
            }

            else -> println("When loop")

        }

        println(getGreeting())
        hello()

        val newTopLevelName1: Int? = topLevelNullname?.length;
        println("The length of topLevelName(with the default value) is $newTopLevelName1")

        topLevelNullname = "Some name here"
        val newTopLevelName2: Int =
            topLevelNullname!!.length; //used only when we know that a nullable variable is assigned a value and making a new non-nullable variable; if the value is null -> throws a NullPointerException
        println("The length of topLevelName(with a value assigned) is $newTopLevelName2")

        //searching a list for nullable objects and removing them from the list
        val nullableList: List<Int?> = listOf(1, 2, null, 4)
        val intList: List<Int> = nullableList.filterNotNull()
        println(intList)

        var a = 1
        val s1 = "a is $a" // simple name in template:

        a = 2
        val s2 = "${s1.replace("is", "was")}, but now is $a" // arbitrary expression in template
        println("s2 values is $s2")

        //for loop to search in a list
        val listOfItems = listOf("banana", "kiwi", "apple")
        for (index in listOfItems.indices)
            println("fruit at index $index is ${listOfItems[index]}")

        //while loop to search in a list
        var index = 0
        while (index < listOfItems.size) {
            println("fruit at index $index is ${listOfItems[index]}")
            index++
        }

        //when expression -> similar to switch in Java
        val x: Any = "Hello";
        var variable: String? = when (x) {
            1 -> "x is one"
            2 -> "x is two"
            3 -> "x is three"
            else -> "unknown value"
        }
        println("When loop variable: $variable")

        val y = 4
        if (y in 10.downTo(1) step 2) println(y) else println("not in range") // it is going to search for 4 starting from 10 and going down to 0 with step 2 - 10, 8, 6, 4,2,0

        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits
            .filter { it.startsWith('k') }
            .sortedBy { it }
            .map { it.uppercase() }
            .forEach { (println(it)) }

        for (fruit in fruits.sorted()) {
            if (fruit.startsWith('a')) {
                println(fruit.uppercase())
            }
        }

        val person = Person("Ivan", "Petrov")
        //person.firstname is known as property access syntax; in Kotlin we can directly reference properties by their name without worrying about a getter or setter
        println("\nFirst name of my Person: ${person.firstname} \nLast name of my Person: ${person.lastName}")

        val map = mapOf("a" to 1, "b" to 2, "c" to 3)
        println(map["a"])
        println(map.getValue("a"))
        //map.forEach { key, value -> println("$key = $value")}
        for ((key, value) in map)
            println("$key = $value ")

        infix fun String.onto(other: String) =
            Pair(this, other) // infix functions can be used for only single parameter
        println("McLaren" onto "Lucas")

        infix fun Int.times(value: String) = value.repeat(this)
        println(3 times "Hello ")

        infix fun String.findIn(value: String) = value.contains(this) //returns a Boolean value
        println("heyy" findIn "Hello world!")

        fun printAll(vararg messages: String) {                            // 1
            for (m in messages) println(m)
        }

        printAll("Hello", "Hallo", "Salut", "Hola", "你好")

        fun log(vararg entries: String) {
            printAll(*entries)                                             // 5
        }


    }

    fun getGreeting(): String {

        return "Hello Kotlin"
    }

    fun hello() {
        println(getGreeting())
    }

    fun hello2() {
        println(getGreeting())
    }

}