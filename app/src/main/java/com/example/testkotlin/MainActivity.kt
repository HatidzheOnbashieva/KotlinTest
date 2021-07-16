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

        val intNumber = 2
        val doubleNumber: Double = intNumber.toDouble() //you have to explicitly do the widening by calling the appropriate data type function
        println(doubleNumber)

        val charInt = 65 //if we assign a value of integer tp a char it will return the char character from the unicode table, however we have to explicitly say so
        println(charInt.toChar())

        val string1:String? = null
        println("It is not giving a null pointer exception even if the value is null: ${string1?.uppercase()}")

        val string2 = null
        //println("It is not giving a null pointer exception even if the value is null: ${string2.uppercase()}")

        val string3 = string1 ?: "This is an Elvis operator default value and will be assigned to string3 variable when the string1 variable is null"
        println("Testing the Elvis operator: $string3")

//        val countryCode = bankBranch?.address?.country?.countryCode
//        val whatever = bankBranch?.address?.country ?: "USA" //the compiler will check for all the values if they are null before accessing the country value and if one of the values is null it will assign a default value
//
//
//        above code is the same as this code in Java
//
//        if(bankBranch != null)
//        {
//            Address address = bankBranch.getAddress();
//            if( address != null)
//            {
//                Country country = address.getCountry();
//                if(country != null)
//                {
//                    String countryCode = country.getCountryCode();
//                }
//            }
//
//        }

        val test1: Any = arrayOf(1,2,3,4)
        val string4 = test1 as? String
        println(string4) // the compiler will show "null" and not an null pointer exception because of the safe cast operator that we use

        val string5: String? = null
        //val newString5 = string5!! //we use !! if we want an exception to be addressed/shown; use this operator when you are sure that the value of the variable is not null
        //println(newString5) // will execute a NullPointerException

        fun printText(text: String)
        {
            println(text)
        }

        val newText: String? = "Some text is put here"
        newText?.let { printText(it)} // if newText is not null then let this fun do whatever it is doing; we can use let if we have a function that accepts non nullable type / prevent from null pointer exception

        val arrayOfNull = arrayOfNulls<Int?>(5)
        for ( i in arrayOfNull)
        println(i)

        // test examples from video 33 at the end of Section 4
        val floatValue = -3847.384F
        val floatValue2: Float = -3847.384F

        val floatValueCopy: Float? = -3847.384F
        val floatValue2Copy: Float? = -3847.384F

        val arrayOfShorts = shortArrayOf(1,2,3,4,5)
        val arrayOfShorts2: Array<Short> = arrayOf(1,2,3,4,5)

        val intArray = Array<Int?> (5) {i -> (i+1) * 5}

        fun method1(arrOfChars: CharArray)
        {
            for(char in arrOfChars)
            println(char)
        }

        val arrOfChars = charArrayOf('a','b','c')
        method1(arrOfChars)

        val str: String? = "I AM IN UPPERCASE"
        val newStr = str?.toLowerCase() ?: "I give up!"
        println(newStr)

        fun printStr(str: String)
        {
            println(str.toLowerCase().replace("am", "am not"))

        }

        str?.let {printStr(it)}

        val myNonNullVariable: Int? = null;
        //val printMyNonNull = myNonNullVariable!!.toDouble() //firing a NullPointerException because myNonNullVariable is null
        //println(printMyNonNull)
        //Test examples from video end

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

        //playing around with strings
        val filePath = """"C:\\Users\\HatidzheOnbashieva""" // you can use triple quoted strings for file paths
        val text = """Комиксовото списание е списание, 
което съдържа комикси под формата на история. 
Комиксите са организирани в отделни панели, 
като самостоятелни сцени и често са съпровождани от диалог. 
Въпреки името си комиксовите списания не са задължително смешни"""
        println("$text \n")

        val text2 = """Комиксовото списание е списание, 
            |което съдържа комикси под формата на история. 
            |Комиксите са организирани в отделни панели, 
            |като самостоятелни сцени и често са съпровождани от диалог. 
            |Въпреки името си комиксовите списания не са задължително смешни""".trimMargin()
        println("$text2 \n")

        val text3 = """Комиксовото списание е списание, 
            *което съдържа комикси под формата на история. 
            *Комиксите са организирани в отделни панели, 
            *като самостоятелни сцени и често са съпровождани от диалог. 
            *Въпреки името си комиксовите списания не са задължително смешни""".trimMargin("*")
        println("$text3  \n")



        val person = Person("Ivan")
        //person.firstname is known as property access syntax; in Kotlin we can directly reference properties by their name without worrying about a getter or setter
        println("\nFirst name of my Person: ${person.firstname}")
        println(person)

        val person2 = Person("John")
        val person3 = Person("John")
        val person4 = person3

        println("$person === $person2: ${person === person2}") //false
        println("$person2 === $person3: ${person2 === person3}") //false
        println("$person == $person2: ${person == person2}") //false
        println("$person2 == $person3: ${person2 == person3}") // true; Update: Changed the overridden equals method in Person class;


        println("$person3 != $person4: ${person3 != person4}") // false; checking for structurally not equal
        println("$person3 !== $person4: ${person3 !== person4}") // false; checking for  referentially not equal
        println("$person2 != $person3: ${person2 != person3}") // false
        println("$person2 !== $person3: ${person2 !== person3}") //true

        val something: Any = person
        if (something is Person) {
            //val newPerson = something as Person // this line is redundant and can be omitted
            //println(newPerson.firstname)
            println(something.firstname) // it is possible to use the variable this way instead of assigning it to a new variable and casting it to a specific class; however this won't work if we change the value of e.g. ' something = "hello"' inside the if condition
        }


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
}