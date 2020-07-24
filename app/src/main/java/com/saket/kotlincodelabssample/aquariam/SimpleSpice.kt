package com.saket.kotlincodelabssample.aquariam

/**
Created by sshriwas on 2020-05-10
 */
class SimpleSpice {
    var name : String = ""
    var spiciness : String = ""
    val heat : Int
    get() = if (spiciness.equals("mild")) 5 else 0
}