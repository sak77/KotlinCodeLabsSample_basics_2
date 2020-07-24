package com.saket.kotlincodelabssample.aquariam

/**
Created by sshriwas on 2020-05-10
 */

fun main(args : Array<String>) {
    //buildAquariam()
    newSpice()
}

fun buildAquariam() {
    val aquariam = Aquariam()

    aquariam.height = 500
    println("Aquariam height: ${aquariam.height} , width: ${aquariam.width} , length: ${aquariam.length}")

    val aquariam2 = Aquariam (10, 20 ,20)
    println("Aquariam2 volume: ${aquariam2.volume}")

    val aquariam3 = Aquariam (numberOfFish = 10)
    println("Required aquariam height ${aquariam3.height}")
}


fun newSpice() {
    val simpleSpice = SimpleSpice()
    simpleSpice.name = "curry"
    simpleSpice.spiciness = "mild"
    //println("Spice name ${simpleSpice.name} and heat level is ${simpleSpice.heat}")


    val listOfSpices = listOf<Spice>(Spice("Curry"),
            Spice("Green Chilly", "hot"),
            Spice("Red Chilly", spiciness = "hot"),
            Spice("Cardimon", "mild"),
            Spice("Garlic", "mild"),
            Spice("Ginger", "mild"))


    //Print all spices using map()
    listOfSpices.map { println("Spice Name: ${it.name}") }

    val mildSpices = listOfSpices.filter { it.heat < 10 }
    //Print all mild spices using map()
    mildSpices.map { println("Mild Name: ${it.name}") }



}