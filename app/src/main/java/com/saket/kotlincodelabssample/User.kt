package com.saket.kotlincodelabssample

/**
 * Created by sshriwas on 2020-05-02
 */

/*
We frequently create classes whose main purpose is to hold data.
In such a class some standard functionality and utility functions are often mechanically derivable from the data.
In Kotlin, this is called a data class and is marked as data:
https://kotlinlang.org/docs/reference/data-classes.html#data-classes
 */

data class User(var firstName: String?, var lastName: String?) {
    //Usage of extension properties
    val user = User("FirstName", "SecondName")
    val formattedname = user.formattadUserName
    val formattedname2 = user.getFormattedUserName()
}