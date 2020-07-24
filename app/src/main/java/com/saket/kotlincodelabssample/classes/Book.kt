package com.saket.kotlincodelabssample.classes

/**
Created by sshriwas on 2020-05-11
 */
/*
classes can be made inheritabe using the open keyword
To override class properties, mark them as open as well
Use override keyword in sub-class to override properties of parent class
to inherit from a class use syntax - class child : parent {}
 */
open class Book (val title : String, val author : String) {
    private var currentPage : Int = 0
    open fun readPage() {
        currentPage++
    }
}

class ebook (title: String, author: String, var format : String = "text") : Book(title, author) {
    private var wordcount : Int = 0
    override fun readPage() {
        wordcount += 250
    }
}


