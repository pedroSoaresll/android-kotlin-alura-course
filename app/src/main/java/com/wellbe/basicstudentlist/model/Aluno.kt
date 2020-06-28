package com.wellbe.basicstudentlist.model

import java.io.Serializable

class Aluno(
    var name: String,
    var phone: String,
    var email: String
) : Serializable {
    constructor() : this("", "", "")

    var id: Int = 0
    fun getHasValidId(): Boolean = id > 0

    override fun toString(): String = name
}
