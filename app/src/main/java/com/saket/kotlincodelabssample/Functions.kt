package com.saket.kotlincodelabssample

import java.util.*

/**
Created by sshriwas on 2020-05-09
 */

fun main(args: Array<String>) {
//dayOfWeek()

    //18println(if (args[0].toInt() < 12) "Good morning Kotlin!" else "Good night Kotlin!")

    do {
        val fortune = getFortuneCookie()
        println("Your fortune is: $fortune")
    } while(!fortune.contains("Take it easy"))

    //val fortune = getFortuneCookie()
    //println("Your fortune is: $fortune")

    //val canFitMoreFish = fitmorefish(10.0f, listOf(), 7,true)
    //println("Can you fit more fish? $canFitMoreFish")
}

fun dayOfWeek() {
    print("What day is it today?")
    when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
        Calendar.SUNDAY -> println("Today is Sunday")
        Calendar.MONDAY -> println("Today is MONDAY")
        Calendar.SATURDAY -> println("Today is Saturday")
    }
}

/*
Get fortune cookie example from Bootcamp lesson 3 - stage 7.
 */
fun getFortuneCookie(): String {
    val fortunes = listOf(
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Take it easy and enjoy life!",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint."
            )

    var birthday = getBirthday()

    if (birthday < 0 || birthday > 31) birthday = 1

    return when (birthday) {
        28, 31 -> "Treasure your friends because they are your greatest fortune."
        in 0..7 -> "You will have a great day!"
        else -> fortunes[birthday.div(fortunes.size)]
    }
}

fun getBirthday() : Int {
    println("Enter your birthday:")
    return readLine()?.toIntOrNull() ?: 1
}


fun fitmorefish(tankSize: Float,  currentFish : List<Int>, fishSize : Int = 2, hasDecorations : Boolean = true) : Boolean {

    //add all current fish size
    var currentSize = currentFish.sum()
    val totalsize = currentSize.plus(fishSize)

    //Check if decorations exist
    return if (hasDecorations) {
        //if yes then fish size can be up to 80% of tank size
        tankSize.times(0.8) >= totalsize
    } else {
        //else fish size can be up to 100% of tank size
        tankSize >= totalsize
    }
}



