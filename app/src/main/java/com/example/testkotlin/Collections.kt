package com.example.testkotlin

fun main()
{
    val strings = listOf("spring", "summer", "fall", "winter")
    val colorList = listOf("black", "black", "black", "white", "green")

    println(strings.javaClass) // we have a immutable list; you can't add and delete anything from the list;
    println(strings.last())
    println(strings.asReversed()) // items get reversed
    println(strings.getOrNull(5)) // this is a concise way of checking if(strings.size>5) {println(strings[5])}
    println(colorList.zip(strings)) //to join two lists and if they are not the same length we are getting pair values; zip function creates pair elements; we are getting one list;

    val mergedList = listOf(colorList, strings)
    println(mergedList) // we are getting a list containing two lists

    val combinedLists = colorList + strings
    println(combinedLists) // we get a list combining the two lists; here we are just concatenating the two lists and keeping the duplicates

    val noDuplicatesList = colorList.union(strings) // we are getting a list that have no duplicates in it
    println(noDuplicatesList)

    val noDuplicateColors = colorList.distinct() //removing the duplicates from a single list
    println(noDuplicateColors)

    val mutableSeasons = strings.toMutableList() //making a list mutable and adding a new element to it
    mutableSeasons.add("some other season")
    println(mutableSeasons)

    val ints = listOf(1,2,3,4,5)
    println(ints.maxOrNull()) // getting the maximum number of items in the list

    var emptyList = emptyList<String>()
    println(emptyList.javaClass)

    if(!emptyList.isEmpty())
    {
        println(emptyList[0])
    }

    val notNullList = listOfNotNull("hello", null,"goodbye")
    println(notNullList) //null values are not added to the list

    val arrayList = arrayListOf(1,2,3)
    println(arrayList.javaClass) //we have a mutable list;

    val mutableList = mutableListOf<Int>(1,2,3) //we can have a mutable list
    println(mutableList.javaClass)
    println(mutableList[2])
    mutableList[1] = 20
    println(mutableList)
    println(mutableList.get(1))


    val array = arrayOf("black", "white", "green")
    //val colorList = listOf(array) // converting an array to a list
    //println(colorList) //we are getting [[Ljava.lang.String;@dfd3711]; we are not getting the individual elements but the array reference
    val colorList1 = array.toList()
    println(colorList1)

    val colorList2 = listOf(*array)
    println(colorList2)

}


