package com.saket.kotlincodelabssample.spices

/**
Created by sshriwas on 2020-05-11
 */
data class SpiceContainer (val spice : Spice) {

    var label = "The lable for this spice is ${spice.name}"
}