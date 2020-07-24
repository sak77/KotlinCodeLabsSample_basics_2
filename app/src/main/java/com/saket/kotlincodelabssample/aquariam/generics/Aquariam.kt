package com.saket.kotlincodelabssample.aquariam.generics

/**
Created by sshriwas on 2020-05-15
 */

//Aquariam water
open class AquariamWaterSupply (var isFilterNeeded : Boolean) {

}
//Tap water - is filter needed? yes  - remove chemical
class TapWater : AquariamWaterSupply(true) {
    //remove chemical
    fun removeChemicalFromWater() {
        //update boolean flag
        isFilterNeeded = false
    }
}
//Lake water - is filter needed? yes - filter
class LakeWater : AquariamWaterSupply(true) {
    fun filterWater() {
        isFilterNeeded = false
    }
}
//Fish shop water - is filter needed ? no
class FishShopWater : AquariamWaterSupply (false)

//Add a generic water supply to class Aquariam
/*
By default the generic type is of type Any? which means it accepts null values.
But you can either remove the ?
to make it non-nullable or you can remove Any all together and replace it with another
type that you want T to be

out and in types are used to give more idea to the IDE whether the generic is used as an return type
or a parameter. out types can only be used as a return type, they cannot be passed to functions except
constructors. in type on the other hand can only be used as a argument to a function.
 */
class Aquariam<out T : AquariamWaterSupply> (val waterSupply : T)

fun addItem(aquariam: Aquariam<AquariamWaterSupply>) { println("water added")}

fun getGenericExample() {
    val myAquariam = Aquariam(TapWater())
    myAquariam.waterSupply.removeChemicalFromWater()

    val myAquariam2 = Aquariam(LakeWater())
    myAquariam2.waterSupply.filterWater()

    //Since T is of type AquariamWaterSupply, the following will not work
    //val myStringAquariam = Aquariam<String>("")
    //val myNullAquariam = Aquariam<AquariamWaterSupply>(null)

    //the below function call gives an error if we do not specify the out type because
    //then kotlin does not know how we use the generic.
    addItem(myAquariam)

}


