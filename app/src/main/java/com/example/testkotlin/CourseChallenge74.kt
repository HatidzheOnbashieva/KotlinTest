package com.example.testkotlin

import java.lang.StringBuilder

fun main(){
    val joe = ChallengePerson("Joe", "Jones", 45)
    val jane = ChallengePerson("Jane", "Smith", 12)
    val mary = ChallengePerson("Mary", "Wilson", 70)
    val john = ChallengePerson("John", "Adams", 32)
    val jean = ChallengePerson("Jean", "Smithson", 66)


    val(fName, lName, age) = joe
    println("fName= $fName, lName= $lName, age= $age")

    val immutableMapOfChallengePersons = mapOf(joe.lastName to joe, jane.lastName to jane, mary.lastName to mary, john.lastName to john, jean.lastName to jean)

    val countLastNameWithS = immutableMapOfChallengePersons.filter{ it.value.lastName.startsWith('S')}.count()
    println(countLastNameWithS)



    val namePairs = immutableMapOfChallengePersons.map { Pair (it.value.firstName, it.value.lastName)} //first solution
    println(namePairs)


    val firstName = immutableMapOfChallengePersons.map { it.value.firstName} //second solution
    val lastName = immutableMapOfChallengePersons.map { it.value.lastName }
    val namePairs2 = firstName.zip(lastName)
    println(namePairs2)


    immutableMapOfChallengePersons.also{
     it.map{ println("${it.value.firstName} is ${it.value.age} years old.")}
 }


    val list1 = listOf(1,4,9,15,33)
    val list2 = listOf(4,55,-83,22,15,101)

    println(list1.intersect(list2)) // first solution

    val list3 = list1.filter { it in list2} //second solution
    println(list3)

    val list3_1 = list1.filter { list2.contains(it)} //third solution
    println(list3_1)

    val regularPaper = Box<Regular>()
    var paper = Box<Paper>()
    paper = regularPaper



}
class ChallengePerson(val firstName: String, val lastName:String, val age: Int){
    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = age
}

class Box<out T>{

}
open class Paper{

}

class Regular: Paper(){

}

class Premium: Paper(){

}