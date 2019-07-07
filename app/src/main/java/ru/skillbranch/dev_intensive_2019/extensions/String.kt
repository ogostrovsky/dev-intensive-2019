package ru.skillbranch.dev_intensive_2019.extensions

import androidx.core.util.rangeTo

fun String.truncate():String{

    var str = this
    str = str.dropLast(str.length -16)
    return str
}