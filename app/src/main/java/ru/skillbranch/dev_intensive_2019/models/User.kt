package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false) {

    //private constructor(builder: Builder) :this(builder.id,builder.firstName)


    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    init {
        println("$firstName $lastName}")
    }

    constructor(id: String) : this(id, "John", "Doe")


    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastId", firstName = firstName, lastName = lastName, avatar = null)
        }
    }
}
  //  inner class UserBuilder {
  //      val id: String = id
  //      var firstName: String?
  //      var lastName: String?
  //      var avatar: String?,
  //      var rating: Int = 0,
  //      var respect: Int = 0,
  //      var lastVisit: Date? = Date(),
  //      var isOnline: Boolean = false)

