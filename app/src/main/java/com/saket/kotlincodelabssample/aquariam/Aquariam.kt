package com.saket.kotlincodelabssample.aquariam

/**
Created by sshriwas on 2020-05-10
 */

/*
You can specify the primary constructor in the class declaration as shown below.
Like functions, constructor params can also have default values
You can specify secondary constructors for this class using the constructor keyword
 */
class Aquariam (var width : Int = 100,var height : Int = 200,var length : Int = 200) {

    //Order of properties is important
    //we can also override the getter of a property as follows -
    var volume : Int
    get() = (width.times(height).times(length)).div(1000)
    set(value) {height = (value/1000) / (width * height)}

    val waterlevel = volume * 0.9

    //Secondary constructor. It must contain call to primary constructor this() and you
    //also have to pass any required arguments.
    constructor(numberOfFish : Int) : this() {
        val waterlevel = numberOfFish * 2000
        val tank = waterlevel + waterlevel* 0.1
        height = (tank/length * width).toInt()
    }
}