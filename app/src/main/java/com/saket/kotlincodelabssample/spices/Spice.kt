package com.saket.kotlincodelabssample.spices

/**
Created by sshriwas on 2020-05-11
 */

fun main() {

    val mycurry: Curry = Curry("Garam masala", "hot")
    print("Color of my curry is ${mycurry.color}")
}


//Interface delegation - Spicecolor is implemented by delegate color
//Interface delegation uses composition to perform inheritance and is preferred over abstract classes in kotlin
abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {

    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            "hot" -> 10
            else -> 0
        }

    init {
        println("Spice created $name, spiciness $spiciness, heat level $heat")
    }

    //
    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String, color: SpiceColor = YellowColor)
    : Spice(name, spiciness, color), Grinder {

    override fun prepareSpice() {
        println("Prepare curry spice")
    }

    override fun grind() {
        println("Grind curry")
    }
}

interface Grinder {
    fun grind()
}

//Interface cannot have constructor
interface SpiceColor {
    val color: Color
}

object YellowColor : SpiceColor {
    override val color = Color.YELLOW
}

//Enum class is a special type of class. It can have its own properties and methods
//like objects there is only one instance of enum created.
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0x00FFFF)
}

/*
Sealed class is a class which can only be sub-classed within the file it is declared.
Making Spice a sealed class helps keep all the spices together in one file.
 */
sealed class SealedSpice(val name: String, val spiciness: String, color: SpiceColor) : SpiceColor by color {
    abstract fun prepareSpice()
}

