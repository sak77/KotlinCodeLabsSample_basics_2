package com.saket.kotlincodelabssample.spices

/**
Created by sshriwas on 2020-05-11
 */
fun main() {
    createSpices()
}

fun createSpices () {
    //Create instance of a Spice. Using Curry here as Spice is abstract and cannot be instantiated directly
    var myCurry = Curry("Garam Masala", "hot")
    val spicecontainer = SpiceContainer(myCurry)
    println(spicecontainer.label)
}
