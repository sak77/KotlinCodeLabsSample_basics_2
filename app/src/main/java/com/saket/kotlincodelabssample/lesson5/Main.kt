package com.saket.kotlincodelabssample.lesson5

/**
Created by sshriwas on 2020-05-11
 */

fun main() {
    val book = Book("1001 Space odyssey","Chris Campbell", "2001")
/*
    //destructuring book
    val (name, author, year) = book
    //println("Here is your book $name written by $author in year $year")

    val BookTitleAuthorPair = book.getTitleAuthorPair()

    val bookTitleAuthorYearTriple = book.getTitleAuthorYearTriplet()
    println("Here is your book ${bookTitleAuthorYearTriple.first} written by ${bookTitleAuthorYearTriple.second} in year ${bookTitleAuthorYearTriple.third}")

    //Set is an unordered list
    val allBooks = setOf("Book1","Book2","Book3")
    val library = mapOf<String, Set<String>>("William Shakespere" to allBooks)

    val hasHamlet = library.any { it.value.contains("hamlet") }
    val moreBooks = mutableMapOf<String, Set<String>>()
    moreBooks["Robin Davidson"] = setOf("Book4", "Book5", "Book6")
    moreBooks.getOrPut("Jacob Martin") { setOf("Book7", "Book8", "Book9")}
*/
    //val canBorrow = Book("Title", "Author", "1999")
    //println("Can borrow more books? ${canBorrow.canBorrow(8)}")

    val myBook = Book("Title", "Author", "2109")
    val myPuppy = Puppy()
    myPuppy.playWithBook(myBook)
}
