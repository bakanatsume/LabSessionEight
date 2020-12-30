package com.bipash.labsessioneight.model

import java.io.Serializable

data class Student(
    var name :String ?= null,
    var address : String ?= null,
    var number : String ?= null,
    var gender : String ?= null,
):Serializable