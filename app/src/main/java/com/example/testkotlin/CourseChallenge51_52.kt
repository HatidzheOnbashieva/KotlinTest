package com.example.testkotlin

open class Bicycle (var cadence: Int, var speed: Int, var gear: Int = 10){

    fun applyBreak(decrement: Int){
        speed -= decrement
    }

    fun speedUp(increment: Int){
        speed += increment
    }

    open fun printDescription() {
        println("Bike is in gear $gear with a cadence of $cadence travelling at a speed of $speed.")
    }
}

class MountainBike (var seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10) : Bicycle(cadence, speed, gear) {

    constructor( color: String, seatHeight: Int, cadence: Int, speed: Int, gear: Int = 20) : this(seatHeight, cadence, speed, gear){
        println("This is the $color")
    }

    override fun printDescription() {
        super.printDescription()
        println("The mountain bike has a seat of $seatHeight inches")
    }

    companion object{
        val availableColors: List<String> = listOf("blue","red","white","black","brown")
    }

}


class RoadBike(val tireWidth: Int, cadence: Int, speed: Int, gear: Int = 10) : Bicycle(cadence, speed, gear){

    override fun printDescription() {
        super.printDescription()
        println("The road bike has a tire of $tireWidth MM")
    }
}

fun main()
{
//    val bicycle = Bicycle(20,15, 20)
//    val mountainBike = MountainBike(10, 10,20,5)
//    val roadBike = RoadBike(20,10,5,10)
//
//    bicycle.printDescription()
//    mountainBike.printDescription()
//    roadBike.printDescription()
//
//    val bicycle2 = Bicycle(20,15)
//    val mountainBike2 = MountainBike(10, 10,20)
//    val roadBike2 = RoadBike(20,10,5)
//
//    bicycle2.printDescription()
//    mountainBike2.printDescription()
//    roadBike2.printDescription()

    val bicycle3 = Bicycle(20,15)
    val mountainBike3 = MountainBike("blue",10, 10,20)
    val roadBike3 = RoadBike(20,10,5)

    bicycle3.printDescription()
    mountainBike3.printDescription()
    roadBike3.printDescription()

    MountainBike.availableColors.forEach {println(it)} // first way to print the colors

    for(color in MountainBike.availableColors) //second way to print the colors
    {
        println(color)
    }
}