package com.saket.kotlincodelabssample.lesson5


const val MAX_BOOKS_ALLOWED = 5

/**
Created by sshriwas on 2020-05-11
 */
data class Book(val title: String, val author: String, val year: String) {

    var pages: Int = 20
    //Function to return Pair of title and author
    fun getTitleAuthorPair() = title to author

    //Function to return Triple of title, author and year
    fun getTitleAuthorYearTriplet(): Triple<String, String, String> {
        return Triple(title, author, year)
    }

    fun canBorrow(books: Int) = books <= MAX_BOOKS_ALLOWED
}

//Extension function weight()
fun Book.weight(): Double {
    return this.pages * 1.5
}

fun Book.tornpages(tornPages : Int): Double {
    return if (pages > tornPages) {
        //Calculate remaining pages
        val remainingpages = this.pages - tornPages
        //return new weight
        remainingpages * 1.5
    } else {
        0.0
    }
}


class Puppy {

    fun playWithBook(book: Book) {
        val number_of_pages_torn = 10   //TODO: Get random value here
        while (book.pages >0) {
            book.pages = book.pages - number_of_pages_torn
            println("Number of pages left in book - ${book.pages}" )
        }
    }
}

class Constants {
    //Companion object is equivalent of static members of the class in java.
    companion object {
        const val BASE_URL = "http://mylibrary.org"
    }

    fun printurl() {
        println("$BASE_URL\"booktitle.html")
    }
}