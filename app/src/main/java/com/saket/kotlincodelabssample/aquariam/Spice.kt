package com.saket.kotlincodelabssample.aquariam

/**
Created by sshriwas on 2020-05-10
 */

class Spice (val name : String, val spiciness : String = "mild") {

    val heat : Int
    get() = when (spiciness) {
        "mild" -> 5
        "hot" -> 10
        else -> 0
    }
    init {
        println("Spice created $name, spiciness $spiciness, heat level $heat")
    }
}

//Helper function to make salt.
fun makeSalt() = Spice ("Salt")