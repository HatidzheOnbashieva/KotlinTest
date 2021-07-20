package com.example.testkotlin

fun main()
{

    for(num in 5..5000 step 5)
        println(num)

    for(num in -500..0)
        println(num)

    var num1 = 0
    var num2 = 1
    var num3:Int
    println(num1)
    println(num2)

    for(num in 1..13)
    {
        num3 = num2 + num1
        num1 = num2
        num2 = num3
        println(num3)
    }
    //first way
    println("First way of showing 1,11,100,99,98,2: ")
    for(i in 1..5)
    {
        println(i)
        if(i == 2)
            break
        jloop@ for(j in 11..20){
            println(j)
            for(k in 100 downTo 90) {
                println(k)
                if (k == 98)
                {
                    break@jloop
                }
            }

        }
    }

    //second way
    println("Second way of showing 1,11,100,99,98,2: ")
    iloop@ for(i in 1..5)
    {
        println(i)
        if(i == 2)
            break
         for(j in 11..20){
            println(j)
            for(k in 100 downTo 90) {
                println(k)
                if (k == 98)
                {
                    continue@iloop
                }
            }

        }
    }

    val num: Int = 3

    // first way of assigning a value
    var dnum1 = when {
        num>100 -> -234.567
        num<100 -> 4444.555
        else -> 0.0
    }
    println(dnum1)

    // second way of assigning a value
    val dnum2 = if(num>100)  -234.567 else if(num<100) 4444.555 else 0.0
    println(dnum2)

}