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
}

fun topLevel() = println("I am in a function!")

fun useParameter(employees: List<Employee>, num: Int) {
    employees.forEach {
        println(it.firstName)
        println(num)
    }
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