package com.example.testkotlin

import java.io.File
import java.nio.file.FileSystems
import java.nio.file.Path

fun main(){

    val reader = File("app\\src\\main\\java\\com\\example\\testkotlin\\testFile.txt").reader()
    val lines = reader.readText()
    //val lines = reader.readLines().forEach { println(it)}
    println(lines)
    reader.close()

//    val lines = File("app\\src\\main\\java\\com\\example\\testkotlin\\testFile.txt").reader().use { it.readText() }
//    val lines = File("app\\src\\main\\java\\com\\example\\testkotlin\\testFile.txt").bufferedReader().use { it.readText() } // the functions with the name use in them will close the resource for us
//    println(lines)
//
//    val lines = File("app\\src\\main\\java\\com\\example\\testkotlin\\testFile.txt").readText() //reading the whole text all at once
//    println(lines)


    File("app\\src\\main\\java\\com\\example\\testkotlin\\testFile.txt").forEachLine{ println(it) } // instead of reading the whole file all at once it is reading it line by line; it close the reader for us

    File("app\\src\\main\\java\\com\\example\\testkotlin\\testFile.txt").useLines{ println(it.forEach { println(it) }) }


    File(".").walkTopDown().forEach { println(it) }
    File(".").walkTopDown().filter { it.name.endsWith(".kt") }.forEach { println(it) }


}
