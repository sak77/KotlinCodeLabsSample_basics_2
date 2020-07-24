package com.saket.kotlincodelabssample.aquariam.generics

/**
Created by sshriwas on 2020-05-15
 */

open class BaseBuildingMaterial(val numberNeeded : Int = 1)

class Wood  : BaseBuildingMaterial(4)

class Brick  : BaseBuildingMaterial(8)

//Generic class building
class Buildings<out T : BaseBuildingMaterial> (private val baseMaterialsNeeded :Int = 100, val buildingMaterial: T) {

    fun actualNumbersNeeded() = baseMaterialsNeeded * buildingMaterial.numberNeeded

    fun build() {
        println("Material type ${buildingMaterial::class.simpleName} and quantity ${actualNumbersNeeded()}")
    }
}

//Generic functions
fun <T: BaseBuildingMaterial> isSmallBuilding(buildings: Buildings<T>) = if (buildings.actualNumbersNeeded() > 500) println("Large building") else print("Small building")

fun main() {
    val myBuilding = Buildings(buildingMaterial = Wood())
    myBuilding.build()

    val myBuilding2 = Buildings(buildingMaterial = Brick())
    myBuilding2.build()

    isSmallBuilding(myBuilding)
}