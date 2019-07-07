package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import java.lang.Math

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

enum class TimeUnits {SECOND, MINUTE, HOUR, DAY;

    fun plural(value:Int):String{
            var base = ""
            val list1 =listOf(2,3,4)
            val list2 =listOf(0,5,6,7,8,9,11,12,13,14,15,16,17,18,19)
        if (this == SECOND) {
            when (value % 10){
                1        -> base = "секунду"
                in list1 -> base = "секунды"
                in list2 -> base = "секунд"}
            when (value % 100){
                1        -> base = "секунду"
                in list1 -> base = "секунды"
                in list2 -> base = "секунд"}}
        if (this == MINUTE) {
            when (value % 10){
                1        -> base = "минуту"
                in list1 -> base = "минуты"
                in list2 -> base = "минут"}
            when (value % 100){
                1        -> base = "минуту"
                in list1 -> base = "минуты"
                in list2 -> base = "минут"}}
        if (this == HOUR) {
            when (value % 10){
                1        -> base = "час"
                in list1 -> base = "часа"
                in list2 -> base = "часов"}
            when (value % 100){
                1        -> base = "час"
                in list1 -> base = "часа"
                in list2 -> base = "часов"}}
        if (this == DAY) {
            when (value % 10){
                1        -> base = "день"
                in list1 -> base = "дня"
                in list2 -> base = "дней"}
            when (value % 100){
                1        -> base = "день"
                in list1 -> base = "дня"
                in list2 -> base = "дней"}}

        return "$value $base"
    }
}

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, timeUnits: TimeUnits): Date {
    var time = this.time
    time += when (timeUnits) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()):String{

    val dif1:Long = (date.time - this.time) / 100

    if (dif1 >= 0){
    if (dif1 in 0..10) return "только что"
       else if (dif1 in 10 ..450) return "несколько секунд назад"
       else if (dif1 in 450..750) return "минуту назад"
       else if (dif1 in 750..27000) return humanizeDiffb((dif1/10)+1,"minute","+")
       else if (dif1 in 27000..45000) return "час назад"
       else if (dif1 in 45000..792000) return humanizeDiffb((dif1/10)+1,"hour","+")
       else if (dif1 in 792000..936000) return "день назад"
       else if (dif1 in 936000..311040000) return humanizeDiffb((dif1/10)+1,"day","+")
        else return "более года назад"}
    val dif2:Long = Math.abs(dif1)
    if (dif1 < 0){
        if      (dif2 in 0..10) return "только что"
        else if (dif2 in 10 ..450) return "через несколько секунд"
        else if (dif2 in 450..750) return "через минуту"
        else if (dif2 in 750..27000) return humanizeDiffb((dif2/10)+1,"minute","-")
        else if (dif2 in 27000..45000) return "через час"
        else if (dif2 in 45000..792000) return humanizeDiffb((dif2/10)+1,"hour","-")
        else if (dif2 in 792000..936000) return "через день"
        else if (dif2 in 936000..311040000) return humanizeDiffb((dif2/10)+1,"day","-")
        else return "более чем через год"} ; return ""}

fun humanizeDiffb (dif1:Long,cons:String,simbol:String):String{
//----------------------------------------------------------------------------------
        var divider:Long = 0
        var baceword = ""
//----------------------------------------------------------------------------------
        when(cons){
            "minute" -> divider = 60
            "hour"   -> divider = 3600
            "day"    -> divider = 86400}
//----------------------------------------------------------------------------------
        val num1 = dif1 / divider
        var num2 = Math.abs(num1) % 100
//----------------------------------------------------------------------------------
        val set056789 = listOf<Long>(0,5,6,7,8,9)
        val set1 =      listOf<Long>(1)
        val set234 =    listOf<Long>(2,3,4)
        val set11_19 = listOf<Long>(11,12,13,14,15,16,17,18,19)
//-------------------------------------------------------------------------------------------
        if      (cons  == "minute" && num2.toInt() == 1) baceword = "минуту"
        else if (cons  == "hour"   && num2.toInt() == 1) baceword = "час"
        else if (cons  == "day"    && num2.toInt() == 1) baceword = "день"
        else if (cons == "minute" && num2 in set11_19)   baceword = "минут"
        else if (cons == "hour"   && num2 in set11_19)   baceword = "часов"
        else if (cons == "day"    && num2 in set11_19)   baceword = "дней"
//-------------------------------------------------------------------------------------------
        if (baceword != "" && simbol == "+") return "$num1 $baceword назад"
        else if (baceword != "" && simbol == "-") return "через $num1 $baceword"
//-------------------------------------------------------------------------------------------
        num2 = Math.abs(num1) % 10
        if (cons == "minute" && num2 in set056789)      baceword = "минут"
        else if (cons == "minute" && num2 in set1)      baceword = "минута"
        else if (cons == "minute" && num2 in set234)    baceword = "минуты"
        else if (cons == "hour"   && num2 in set056789) baceword = "часов"
        else if (cons == "hour"   && num2 in set1)      baceword = "час"
        else if (cons == "hour"   && num2 in set234)    baceword = "часа"
        else if (cons == "day"    && num2 in set056789) baceword = "дней"
        else if (cons == "day"    && num2 in set1)      baceword = "день"
        else if (cons == "day"    && num2 in set234)    baceword = "дня"
//-------------------------------------------------------------------------------------------
        if (simbol == "+")
            return "$num1 $baceword назад"
        else return "через $num1 $baceword"}


