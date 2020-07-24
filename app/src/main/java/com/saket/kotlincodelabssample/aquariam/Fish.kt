package com.saket.kotlincodelabssample.aquariam

/**
Created by sshriwas on 2020-05-10
 */

/*
Here volumeNeeded is not a val/var. So kotlin does NOT create a property for this value in this class.
 */
class Fish (val friendly : Boolean = true, volumeNeeded : Int) {

    val size : Int

    init {
        println("first init block")
    }

    //It is not common in kotlin to have secondary constructors.
    //Instead in kotlin it is a good practice to have a primary constructor with default params and init blocks
    constructor() : this(true, 100) {
        println("In secondary constructor")
    }

    //You can have more than one init blocks. They are always called before secondary constructor
    init {
        size = if (friendly) {
            volumeNeeded
        } else {
            volumeNeeded * 2
        }
    }

    init {
        println("constructed fish of size $volumeNeeded  final size ${this.size}")
    }
}

//Helper method for default fish...this can be used in case of seoondary constructor
fun makeDefaultFish() = Fish(true, 50)

fun printFish() {
    val myFish = Fish(true, 200)
    println("Is the fish friendly? ${myFish.friendly}. It needs volume ${myFish.size}")
}