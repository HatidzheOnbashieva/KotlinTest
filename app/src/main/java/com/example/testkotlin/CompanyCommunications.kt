package com.example.testkotlin

import java.time.Year

fun main()
{
    println(CompanyCommunications.getTagline()) //there is only one instance of an object and it is created the first time the class is used
    println(CompanyCommunications.getCopyrightLine())

    println(SomeClass.Companion.accessPrivateVar()) //both ways are valid calls to companion objects
    println(SomeClass.accessPrivateVar())

    val someClass1 = SomeClass.justAssign("this is the string as is")
    val someClass2 = SomeClass.upperOrLowerCase("this is the string as is", false)
    println(someClass1.someString)
    println(someClass2.someString)

    wantsSomeInterface(object: SomeInterface{
        override fun mustImplement(num: Int) = "This is from mustImplement: ${num * 100}"
    })

    println(Department.ACCOUNTING.getDeptInfo())
}
object CompanyCommunications { //this is sthe way we are creating Singletons in Kotlin

    var currentYear = Year.now().value
    fun getTagline() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our company. All rights reserved."


}

class SomeClass private constructor (val someString: String){
    companion object /* we can also declare a companion name here*/ {
        private var privateVar = 6

        fun accessPrivateVar() = "I'm accessing privateVar: $privateVar"

        fun justAssign(str: String) = SomeClass(str)
        fun upperOrLowerCase(str: String, lowerCase: Boolean) : SomeClass
        {
            if(lowerCase){
                return SomeClass(str.toLowerCase())
            }
            else {
                return SomeClass(str.toUpperCase())
            }
        }
    }
}

interface SomeInterface{
    fun mustImplement(num:Int): String
}

fun wantsSomeInterface(si: SomeInterface){
    println("Printing from wantsSomeInterface ${si.mustImplement(22)}")
}

enum class Department(val fullName: String, val numEmployees: Int)
{
    HR("Human resources", 3),
    IT("IT", 10),
    ACCOUNTING("Accounting",3),
    SALES("Sales", 10);

    fun getDeptInfo() = "The $fullName department has $numEmployees employees"
}