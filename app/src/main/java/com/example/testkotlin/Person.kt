package com.example.testkotlin

class Person (var firstname: String)
{
    override fun equals(other: Any?): Boolean {
        if(other is Person) {
            return super.equals(other)
        }
        return false
    }

    override fun toString(): String {
        return "Person first name: $firstname"
    }
}