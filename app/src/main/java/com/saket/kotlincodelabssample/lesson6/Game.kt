package com.saket.kotlincodelabssample.lesson6

/**
Created by sshriwas on 2020-05-16
 */

enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
    var path = mutableListOf(Directions.START)

    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }

    val end = {
        path.add(Directions.END);
        println("Game Over");
        println("$path");
        path.clear();false
    }

    fun makeMove(argumentString: String?) {
        val myLocation = Location()
        when (argumentString) {
            "n" -> move(north).also { myLocation.updateLocation(north) }
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }
    }
}

fun main() {

    val myGame = Game()
    /*println("Path - ${myGame.path}")
    myGame.north.invoke()
    myGame.south.invoke()
    myGame.east.invoke()
    myGame.west.invoke()
    myGame.end.invoke()
    println("Path - ${myGame.path}")
    */

    //
    //val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    //println("New list: ${numbers.isDivisibleBy3 { rem(3) }}")


    while (true) {
        print("Enter a direction: n/s/e/w:")
        myGame.makeMove(readLine())
    }
}

/*
Higher order function that takes a list and a lambda that on int
Here we create an extension function to an Integer list called isDivisibleBy3
The param is named block. It applies an extension lambda on integer type and returns an int value.
The body of this extension function is supplied as a parameter when calling this function.


Every time isDivisibleBy3 is called, kotlin will make a lambda object. Lambdas are object.
Lambda expression is an instance fo a functional interface which is a sub-type of object.

To fix this problem we have Inline functions tell kotlin to replace the call to lambda with the
 body of the inline function. Thus no new lambda objects are created and that saves CPU.
 However inline for large functions increases code size. So its best to use for simple functions like below.
 */
inline fun List<Int>.isDivisibleBy3(block: Int.() -> Int): List<Int> {
    /* OLD WAY
     val myOutput = mutableListOf<Int>()

    for (number in this) {
        if (number.block() == 0) myOutput.add(number)
    }
    return myOutput*/

    return filter { it.block() == 0 }
}

//Function move that takes a lambda with no arguments that returns Unit.
//notice how we declare lambda with no arguments in function signature
fun move(where: () -> Boolean) = where.invoke()

class Location(val height : Int = 4, val width : Int = 4) {

    //Creating a width x height matrix
    val map = Array(width) { arrayOfNulls<String>(height)}
    var currentPosition = mutableMapOf<Int, Int>()

    init {
        //init map
        //loop through indices in map
        for (i in map.indices) {
            //loop through array at this index
            for (j in map[i].indices) {
                map[i][j] = "Current position is ($i, $j)"
            }
        }
    }

    //Display current location of user
    fun updateLocation(currentDirection : Directions) {
        //update index of current position based on move
        val move = when (currentDirection) {
            Directions.NORTH -> "Moved north"
            Directions.SOUTH -> "Moved south"
            Directions.EAST -> "Moved east"
            Directions.WEST -> "Moved west"
            Directions.END -> "End moves"
            Directions.START -> "Start moving"
        }
        println(move)
        //make sure current index is not outside index of map

    }

}

