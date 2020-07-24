package com.saket.kotlincodelabssample

import java.lang.Math.random
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

/**
Created by sshriwas on 2020-05-10
 */

fun main(args: Array<String>) {
    //val today = whatShouldIDoToday( weather = "sunny")
    //println("Today, $today")
    filterlist()
    //getRandom()
}

fun whatShouldIDoToday(mood : String= getMood(), weather: String = "Sunny", temperature : Int = 24) : String {

    val isMoodHappyAndWeatherSunny = mood.equals("Happy", true) && weather.equals("Sunny", true)
    val isMoodSadAndWeatherRainyAndTempZero = mood.equals("sad", true) && weather.equals("rainy", true) && temperature == 0
    val isTempWarm = temperature > 30

    return when {
        isMoodHappyAndWeatherSunny -> "Go for a walk"
        isMoodSadAndWeatherRainyAndTempZero -> "Stay in bed"
        isTempWarm -> "Go for a swim"
        else -> "Stay at home and read"
    }
}

fun getMood() : String {
    println("Hi, how is your mood today?")
    return readLine() ?: "Happy"
}


fun filterlist() {
    var daysOfWeek = listOf<String>("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    //Filter days starting with letter S. This will create new list each time filter is called.
    val filteredWeek = daysOfWeek.filter { it[0] == 'S' }
    println("Filtered days of week $filteredWeek")

    //We can create a lazy list by using sequenceof()
    val lazyFilter = daysOfWeek.asSequence().filter { it[0] == 'T' }
    //Here if we directly print the val lazyFilter then it does apply the filter nor show any days
    println("Lazy days 1 ; $lazyFilter")

    //But when we invoke any particular item in the sequence, the filter gets applied and we see the result
    println("Lazy days 2 ; ${lazyFilter.first()}")
    println("Lazy days as list ; ${lazyFilter.toList()}") //toList() applies the filter and  converts the sequence to a list

}


fun getRandom() {
    val rollDice = {sides : Int -> if (sides == 0) 0 else ThreadLocalRandom.current().nextInt(sides, 12)}
    //println(rollDice.invoke(3))

    //Now using function type
    val rollDice2 : (Int) -> Int = {sides -> if (sides == 0) 0 else ThreadLocalRandom.current().nextInt(sides, 12)}
    //println(rollDice2.invoke(3))
    gamePlay(rollDice2(2))
}

fun gamePlay(diceroll : Int) {
    println(diceroll)
}
