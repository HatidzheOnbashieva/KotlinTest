package com.example.testkotlin

data class Car(val color: String, val model: String, val year:Int) {
    //a custom implementation of the equals and hash-code functions and copy functions; if we don't want the default implementation we can override these functions and our version of that function will be used
    //all the primary constructor parameters should be declared val or var; they can't be abstract, sealed or inner classes
    //they are great when you have class that are storing state information and not doing anything else


}

class Person(var firstname: String, lastName: String) {
    var lastName =
        lastName // event with this declaration we get the getter and setter by default; if you want a custom getter or setter you need to declare them immediately after the property declaration

        get() {
            println("Running the custom get for lastName property")
            return field // this is the only place we can access the backing field directly
        }
        set(value) {
            println("Running the custom set for yhe lastName property")
            field = value
        }

    override fun equals(other: Any?): Boolean {
        if (other is Person) {
            return super.equals(other)
        }
        return false
    }

    override fun toString(): String {
        return "Person first name: $firstname Person last name: $lastName"
    }

    fun firstNameToUpper(): String {
        return firstname.toUpperCase()
    }




}

class Test  {

    var anotherName:String = "another name"
        get()
        {
            return field
        }
        set(value)
        {
            field = value
        }
}

val Test.another: String
    get() = "another Name in Test.anotherName:String"

val Test.name:String
    get() = "name"