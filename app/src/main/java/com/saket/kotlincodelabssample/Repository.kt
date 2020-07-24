package com.saket.kotlincodelabssample

import java.util.*

/*
With Kotlin, you can enforce Singleton pattern at the compiler level by replacing the class keyword with object.
So here we remove the private constructor and companion object

 */

//Declaring top level property formattedUserName. Maybe also known as extension property
//Note that the property formattedUserName extends from class User.
val User.formattadUserName: String
    get() {
        return if (lastName != null) {
            if (firstName != null) {
                "$firstName $lastName"
            } else {
                lastName ?: "Unknown"
            }
        } else {
            firstName ?: "unknown"
        }
    }

//Declaring top level function to get formatted user name. Maybe also known as extension function
//Note that the function getFormattedUserName() extends from class User.
fun User.getFormattedUserName() : String {
    return if (lastName != null) {
        if (firstName != null) {
            "$firstName $lastName"
        } else {
            lastName ?: "Unknown"
        }
    } else {
        firstName ?: "unknown"
    }
}


object Repository {

    private var _users = mutableListOf<User>()
    val users: List<User>
        get() = _users

            val formattedUserNames: List<String?>
            get() {
                //Using extension property to get formatted name
                return _users.map { user -> user.formattedname }
                //val userNames = ArrayList<String>(_users!!.size)
                //Using destructuring declarations we can destructure a data class intstance into
                //its individual members. We surrond the memebers in brackets like below.
                //For more info - https://kotlinlang.org/docs/reference/multi-declarations.html
                /*for ((firstName, lastName) in users!!) {
                    val name: String = if (lastName != null) {
                        if (firstName != null) {
                            "$firstName $lastName"
                        } else {
                            lastName
                        }
                    } else firstName ?: "Unknown"       //Elvis operator "?:"  - The elvis operator will return the expression on its left hand side if it's not null, or the expression on its right hand side, if the left hand side is null.
                 */
/*
                //Using map operator instead of the for loop is much better way of working with collections..
                return _users.map { user ->
                    if (user.lastName != null) {
                        if (user.firstName != null) {
                            "${user.firstName} ${user.lastName}"
                        } else {
                            user.lastName
                        }
                    } else user.firstName ?: "Unknown"
                }

 */
//userNames.add(name)
                //}
                //return userNames
            }

            // keeping the constructor private to enforce the usage of getInstance
            /*
            In Kotlin, the primary constructor cannot contain any code,
             so initialization code is placed in init blocks. The functionality is the same.
             */
            init {

                val user1 = User("Jane", "")
                val user2 = User("John", null)
                val user3 = User("Anne", "Doe")
                //users = ArrayList()

                /*
                Scope functions are functions or lambdas which are defined for a particular object.
                They run within scope of current object. There are 5 scope functions and they pretty
                much do the same thing: Execute a block of code. But how the object instance is passed
                to the scope function and what it returns is what somewhat differentiates them. But they
                can still be used interchangeably in the code.

                For more details refer - https://kotlinlang.org/docs/reference/scope-functions.html
                 */
                /*_users.add(user1)
                _users.add(user2)
                _users.add(user3)*/
                /*
                  Let - object is passed as a lambda argument (it) and returns lambda result.
                  Can be added to result of chain of operations. 'it' can not be removed when calling
                  object functions.

                  let is often used for executing a code block only with non-null values.
                  To perform actions on a non-null object, use the safe call operator ?.
                  For more details read - https://kotlinlang.org/docs/reference/scope-functions.html#let
                 */

                //In below example let returns boolean which is the return type of it.add operation.
                _users.let {
                    it.add(user1)
                   it.add(user2)
                   it.add(user3)
                }

                //Another example of using let on result of chain of operations
                val numbers = mutableListOf("One", "Two", "Three", "Four")
                numbers.map { it.length }.filter { it > 3 }.let { println(it) } //since let function only has single call to another function, it can be replaced by method reference as ::println

                /*
                apply - object is passed as lambda reference (this) and returns the object itself.
                Hence this can be omitted within the function.

                Use apply for code blocks that don't return a value and mainly operate on the members of the receiver object.
                The common case for apply is the object configuration.

                Such calls can be read as “apply the following assignments to the object.”

                It can be used as part of chain of operations. Maybe like a builder pattern.

                For more info read - https://kotlinlang.org/docs/reference/scope-functions.html#apply
                 */
                //In below operation apply returns MutableList<User> which is as _users.apply
               val newusers = _users.apply {
                    add(user1)
                    add(user2)
                    add(user3)
                }

                /*
                with - A non-extension function. The object is passed as this but the return is lambda result.

                We recommend with for calling functions on the context object without providing the lambda result.
                In the code, with can be read as “with this object, do the following.”

                Another use case for with is introducing a helper object whose properties or functions will be
                 used for calculating a value.

                 For more details - https://kotlinlang.org/docs/reference/scope-functions.html#with
                 */
                val isadded = with(_users) {
                    add(user1)
                    add(user2)
                    add(user3)
                }

                /*
                run - object is available as this and returns lambda result.

                run does the same as with but invokes as let - as an extension function of the context object.
                run is useful when your lambda contains both the object initialization and the computation of the return value.
                run can also be used as a non-extension function where you want to run a block of code and an expression is required.

                 */
                _users.run {
                    add(user1)
                    add(user2)
                    add(user3)
                }

                /*
                also - context object is available as argument (it) and return value is object itself.
                also is good for performing some actions that take the context object as an argument.
                Use also for actions that need a reference rather to the object than to its properties
                and functions, or when you don't want to shadow this reference from an outer scope.

                When you see also in the code, you can read it as “and also do the following with the object.”

                For more details - https://kotlinlang.org/docs/reference/scope-functions.html#also
                 */
                val mynumbers = mutableListOf("one", "two", "three")
                numbers
                        .also { println("The list elements before adding new one: $it") }
                        .add("four")
            }

            //Instead of exposing the mutable list of users, we use a backing property
            //we first change users from var to val
            //as a naming convention, we change this val users to val _users
            //then we create a new val list of users
            //and we override its accessor method get() to return value of _users
            //this way no calling method can change value of user list as it is a val
            //but within Repository class, the list is mutable
            //for more details - https://kotlinlang.org/docs/reference/properties.html#properties-and-fields
            /*fun getUsers(): List<User>? {
                return _users
            } */

            /*
            In Java, we use the static keyword for fields or functions to say that they belong to a class
            but not to an instance of the class.

            The Kotlin equivalent for this is the companion object block.
            Here you would also declare the static fields and static functions.
             */
            /*companion object {
                private var INSTANCE: Repository? = null
                val instance: Repository?
                    get() {
                        if (INSTANCE == null) {
                            synchronized(Repository::class.java) {
                                if (INSTANCE == null) {
                                    INSTANCE = Repository()
                                }
                            }
                        }
                        return INSTANCE
                    }
            }*/
        //}
}