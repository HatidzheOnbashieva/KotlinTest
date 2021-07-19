package com.example.testkotlin

abstract class Printer (val modelName: String){ //the classes if not declared abstract should also be declared open if you want them later to be inherited

    open fun printModel() = println("The model name if this printer is $modelName") //here we need to make a function open otherwise it won't be overrideable
    abstract fun bestSellingPrice():Double //abstract functions are open by default

}

open class LaserPrinter(modelName: String, numberOfPages: Int) : Printer(modelName)
{
    final override fun printModel() = println("The model name for laser printer is $modelName")
    override fun bestSellingPrice(): Double = 129.99

}

//class SpecialLaserPrinter(modelName:String) : LaserPrinter(modelName)
//{
//
//}