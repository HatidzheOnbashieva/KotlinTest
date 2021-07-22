package com.example.testkotlin;

import java.io.IOException;

public class JavaClass {
    public static void main(String [] args){

        StaticCar.topLevelFunction();
        StaticCar.print("Hello! This is coming from Java!");

        CarJava carJava = new CarJava("blue", "BMW", 2011, true);
        //System.out.println(carJava.getModel()); //we call getModel() because the compiler has generated getters and setters under the covers

//        carJava.setColor("purple");
//        System.out.println(carJava.getColor()); // the color is "always green"

        System.out.println(carJava.isAutomatic()); // when dealing with Booleans the generated get actually start with Is...
        carJava.setAutomatic(false); //set stays the same

        System.out.println(carJava.model);

        CarJava.carComp();

        try {
            StaticCar.doIO(); //we will get an IOException
        }catch(IOException e){
            System.out.println("IOException!"); // this is getting printed out
        }

        StaticCar.defaultArgs("The number is: ");
        StaticCar.defaultArgs("The number is: ", 20);
    }

}
