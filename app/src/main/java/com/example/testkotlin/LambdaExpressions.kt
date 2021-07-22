package com.example.testkotlin

import java.lang.StringBuilder

fun main() {
    run { println("I am in a lambda") }
    val employees = listOf(
        Employee("John", "Smith", 2015),
        Employee("Mary", "Johnson", 2002),
        Employee("Mike", "Jones", 2014)
    )

    println(employees.minByOrNull { it.startYear })
    println(employees.minByOrNull(Employee::startYear)) //member reference usage
    //println(employees.minByOrNull { e -> e.startYear })
    //println(employees.minByOrNull { e: Employee -> e.startYear })

    run(::topLevel)

    println(countTo100())

    findByLastName(employees,"Jones")
    findByLastName(employees,"Smithson")

    //
    "Some String".apply someString@ {
        "Another String".apply{
            println(toLowerCase()) //toLowerCase() is applicable only for "Another String"
            println(this@someString.toUpperCase()) //we label the outer apply so we this way we are using the "Some String" expression to make it upperCase
        }
    }
}

fun topLevel() = println("I am in a function!")

fun useParameter(employees: List<Employee>, num: Int) {
    employees.forEach {
        println(it.firstName)
        println(num)
    }
}

fun findByLastName(employees: List<Employee>, lastName: String) {
    employees.forEach returnBlock@{
        if (it.lastName == lastName) {
            println("Yes, there is an employee with the last name $lastName")
            return@returnBlock //the return is a local return now; it returns from the forEach lambda but not return from the function; we will see the nope line printed too
        }
    }
    println("No, there is no employee with the last name $lastName")
}

// this is the more concise way of writing this function using with; Receiver object
/*
fun countTo100() =
    with(StringBuilder()) {
        for(i in 1..99){
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }
*/

// this is the more concise way of writing this function using apply; Receiver object
fun countTo100() =
    StringBuilder().apply {
        for(i in 1..99){
            append(i)
            append(", ")
        }
        append(100)

    }.toString()


/*fun countTo100(): String{
    val numbers = StringBuilder()
    for(i in 1..99){
        numbers.append(i)
        numbers.append(", ")
    }
    numbers.append(100)
    return numbers.toString()
}*/


data class Employee(val firstName: String, val lastName: String, val startYear: Int) {

}